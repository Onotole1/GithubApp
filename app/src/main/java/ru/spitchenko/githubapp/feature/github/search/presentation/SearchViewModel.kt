package ru.spitchenko.githubapp.feature.github.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.spitchenko.githubapp.component.lifecycle.MutableSingleLiveEvent
import ru.spitchenko.githubapp.component.lifecycle.SingleLiveEvent
import ru.spitchenko.githubapp.component.network.NetworkError
import ru.spitchenko.githubapp.component.network.NetworkErrorHandler
import ru.spitchenko.githubapp.feature.github.search.domain.AddToFavorites
import ru.spitchenko.githubapp.feature.github.search.domain.RemoveFromFavorites
import ru.spitchenko.githubapp.feature.github.search.domain.Search
import ru.spitchenko.githubapp.feature.github.search.presentation.model.ErrorUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.ProgressUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.RepositoryUiModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.UiState
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val search: Search,
    private val addToFavorites: AddToFavorites,
    private val removeFromFavorites: RemoveFromFavorites
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 30
    }

    private val _errorEvent = MutableSingleLiveEvent<NetworkError>()
    val errorEvent: SingleLiveEvent<NetworkError>
        get() = _errorEvent
    private val _uiModel = MutableLiveData<UiState>(UiState.Empty)
    val uiModel: LiveData<UiState>
        get() = _uiModel

    private var repositories: List<RepositoryUiModel> = emptyList()

    private var loadPageJob: Job? = null
    private var refreshJob: Job? = null
    private var favoritesJob: Job? = null

    private var currentState: PagingState<RepositoryUiModel> = Empty

    private var query: String = ""

    fun addToFavorites(repositoryUiModel: RepositoryUiModel) {
        favoritesJob?.cancel()
        favoritesJob = viewModelScope.launch {
            addToFavorites(repositoryUiModel.repository)

            setFavorite(true, repositoryUiModel)
        }
    }

    fun removeFromFavorites(repositoryUiModel: RepositoryUiModel) {
        favoritesJob?.cancel()
        favoritesJob = viewModelScope.launch {
            removeFromFavorites(repositoryUiModel.repository.id)

            setFavorite(false, repositoryUiModel)
        }
    }

    private fun setFavorite(favorite: Boolean, repositoryUiModel: RepositoryUiModel) {
        val repositoryIndex = repositories.indexOfFirst { it.itemId == repositoryUiModel.itemId }
        repositories = repositories.toMutableList().apply {
            set(
                repositoryIndex,
                repositoryUiModel.copy(repository = repositoryUiModel.repository.copy(favorite = favorite))
            )
        }

        currentState.setFavorite(repositories)
    }

    fun search(query: String) {
        refreshJob?.cancel()
        loadPageJob?.cancel()

        if (query == this.query) return

        this.query = query

        repositories = emptyList()

        if (query.isBlank()) {
            currentState = Empty
            _uiModel.value = UiState.Empty
            return
        }

        currentState = EmptyProgress()

        _uiModel.value = UiState.EmptyProgress

        startLoading()
    }

    fun showNextPage() {
        currentState.showNextPage()
    }

    fun refresh(): Unit = currentState.refresh()

    fun retry(): Unit = currentState.retry()

    private interface PagingState<T> {

        fun retry() = Unit
        fun refresh() = Unit
        fun showNextPage() = Unit
        fun newData(data: List<T>) = Unit
        fun fail(throwable: Throwable) = Unit
        fun setFavorite(data: List<T>) = Unit
    }

    private object Empty : PagingState<RepositoryUiModel>

    private inner class EmptyProgress : PagingState<RepositoryUiModel> {

        override fun refresh() {
            startLoading()
        }

        override fun newData(data: List<RepositoryUiModel>) {
            if (data.isNotEmpty()) {
                currentState = if (data.size == PAGE_SIZE) Data() else AllData()
                repositories = data
                _uiModel.value = UiState.Data(data)
            } else {
                currentState = EmptyData()

                _uiModel.value = UiState.NotFound
            }
        }

        override fun fail(throwable: Throwable) {
            val error = NetworkErrorHandler.handle(throwable)

            currentState = EmptyError(error)

            _uiModel.value = UiState.Error(error)
        }
    }

    private inner class EmptyError(private val error: NetworkError) : PagingState<RepositoryUiModel> {

        override fun refresh() {
            currentState = EmptyProgress()

            _uiModel.value = UiState.Refreshing.Error(error)

            refreshLoading()
        }
    }

    private inner class EmptyData : PagingState<RepositoryUiModel> {

        override fun refresh() {
            currentState = EmptyProgress()

            _uiModel.value = UiState.Refreshing.Empty

            startLoading()
        }
    }

    private inner class Data : PagingState<RepositoryUiModel> {

        override fun refresh() {
            currentState = Refresh()

            _uiModel.value = UiState.Refreshing.Data(repositories)

            refreshLoading()
        }

        override fun showNextPage() {
            currentState = PageProgress()

            _uiModel.value = UiState.Data(repositories + ProgressUiModel)

            startLoading()
        }

        override fun setFavorite(data: List<RepositoryUiModel>) {
            _uiModel.value = UiState.Data(data)
        }
    }

    private inner class PageError(private val error: NetworkError) : PagingState<RepositoryUiModel> {

        override fun refresh() {
            currentState = Refresh()

            _uiModel.value = UiState.Refreshing.Data(repositories)

            refreshLoading()
        }

        override fun retry() {
            currentState = PageProgress()

            _uiModel.value = UiState.Data(repositories + ProgressUiModel)

            startLoading()
        }

        override fun setFavorite(data: List<RepositoryUiModel>) {
            _uiModel.value = UiState.Refreshing.Data(data + ErrorUiModel(error))
        }
    }

    private inner class Refresh : PagingState<RepositoryUiModel> {

        override fun refresh() {
            startLoading()
        }

        override fun newData(data: List<RepositoryUiModel>) {
            repositories = data
            if (data.isNotEmpty()) {
                currentState = if (data.size == PAGE_SIZE) Data() else AllData()
                repositories = data
                _uiModel.value = UiState.Data(data)
            } else {
                currentState = EmptyData()

                _uiModel.value = UiState.NotFound
            }
        }

        override fun fail(throwable: Throwable) {
            currentState = Data()

            _uiModel.value = UiState.Data(repositories)

            _errorEvent.sendEvent(NetworkErrorHandler.handle(throwable))
        }

        override fun setFavorite(data: List<RepositoryUiModel>) {
            _uiModel.value = UiState.Refreshing.Data(data)
        }
    }

    private inner class PageProgress : PagingState<RepositoryUiModel> {

        override fun newData(data: List<RepositoryUiModel>) {
            repositories = repositories + data
            if (data.isNotEmpty()) {
                currentState = if (data.size == PAGE_SIZE) Data() else AllData()
                _uiModel.value = UiState.Data(repositories)
            } else {
                currentState = EmptyData()

                _uiModel.value = UiState.NotFound
            }
        }

        override fun refresh() {
            currentState = Refresh()

            _uiModel.value = UiState.Refreshing.Data(repositories)

            refreshLoading()
        }

        override fun fail(throwable: Throwable) {
            val error = NetworkErrorHandler.handle(throwable)

            currentState = PageError(error)

            _uiModel.value = UiState.Data(
                repositories + ErrorUiModel(
                    error
                )
            )
        }

        override fun setFavorite(data: List<RepositoryUiModel>) {
            _uiModel.value = UiState.Data(data + ProgressUiModel)
        }
    }

    private inner class AllData : PagingState<RepositoryUiModel> {

        override fun refresh() {
            currentState = Refresh()

            _uiModel.value = UiState.Refreshing.Data(repositories)

            refreshLoading()
        }

        override fun setFavorite(data: List<RepositoryUiModel>) {
            _uiModel.value = UiState.Data(data)
        }
    }

    private fun startLoading() {
        loadPageJob?.cancel()
        loadPageJob = viewModelScope.launch {
            try {
                val page = repositories.size / PAGE_SIZE + 1

                val nextPage = search.invoke(query, PAGE_SIZE, page).map(::RepositoryUiModel)

                currentState.newData(nextPage)
            } catch (exception: CancellationException) {
                throw exception
            } catch (exception: Exception) {
                fail(exception)
            }
        }
    }

    private fun refreshLoading() {
        refreshJob?.cancel()
        loadPageJob?.cancel()
        refreshJob = viewModelScope.launch {
            try {
                val newPage = search.invoke(query, PAGE_SIZE, 1).map(::RepositoryUiModel)

                repositories = emptyList()
                currentState.newData(newPage)
            } catch (exception: CancellationException) {
                throw exception
            } catch (exception: Exception) {
                fail(exception)
            }
        }
    }

    private fun fail(throwable: Throwable) {
        currentState.fail(throwable)
    }
}
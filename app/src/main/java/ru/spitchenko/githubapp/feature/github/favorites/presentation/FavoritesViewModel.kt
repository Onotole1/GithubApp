package ru.spitchenko.githubapp.feature.github.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map
import ru.spitchenko.githubapp.feature.github.favorites.domain.ObserveFavorites
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    observeFavorites: ObserveFavorites
) : ViewModel() {

    val favorites = observeFavorites()
        .map {
            it.map(::RepositoryUiModel)
        }
        .asLiveData()
}
package ru.spitchenko.githubapp.feature.github.search.presentation.model

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.component.network.NetworkError

sealed class UiState {

    object Empty : UiState()
    object NotFound: UiState()
    data class Data(val items: List<BindingClass>) : UiState()
    data class Error(val error: NetworkError) : UiState()
    object EmptyProgress : UiState()
    sealed class Refreshing : UiState() {

        data class Data(val items: List<BindingClass>) : Refreshing()
        object Empty : Refreshing()
        data class Error(val error: NetworkError) : Refreshing()
    }
}
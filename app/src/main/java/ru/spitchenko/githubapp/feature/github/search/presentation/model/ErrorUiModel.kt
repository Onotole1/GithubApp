package ru.spitchenko.githubapp.feature.github.search.presentation.model

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.component.network.NetworkError

data class ErrorUiModel(val error: NetworkError) : BindingClass
package ru.spitchenko.githubapp.feature.github.favorites.presentation

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.feature.github.domain.model.Repository

data class RepositoryUiModel(val repository: Repository): BindingClass
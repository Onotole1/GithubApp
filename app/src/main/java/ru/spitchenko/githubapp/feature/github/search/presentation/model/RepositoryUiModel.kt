package ru.spitchenko.githubapp.feature.github.search.presentation.model

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.search.domain.FavoriteRepository

data class RepositoryUiModel(val repository: FavoriteRepository) : BindingClass {

    override val itemId: Long = repository.id
}
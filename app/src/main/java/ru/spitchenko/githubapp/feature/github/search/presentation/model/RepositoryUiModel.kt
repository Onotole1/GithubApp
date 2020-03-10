package ru.spitchenko.githubapp.feature.github.search.presentation.model

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.feature.github.domain.model.Repository

data class RepositoryUiModel(val repository: Repository, val favorite: Boolean) : BindingClass {

    override val itemId: Long = repository.id
}
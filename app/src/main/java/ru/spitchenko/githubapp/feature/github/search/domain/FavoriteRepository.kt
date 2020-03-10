package ru.spitchenko.githubapp.feature.github.search.domain

import kotlinx.serialization.Serializable
import ru.spitchenko.githubapp.feature.github.domain.model.Repository

@Serializable
data class FavoriteRepository(
    private val repository: Repository,
    val favorite: Boolean
) : Repository by repository
package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository

interface FavoritesRepository {

    suspend fun addToFavorite(repository: Repository)
    suspend fun removeFromFavorites(repositoryId: Long)
    suspend fun getFavorites(repositories: List<Repository>): List<Repository>
}
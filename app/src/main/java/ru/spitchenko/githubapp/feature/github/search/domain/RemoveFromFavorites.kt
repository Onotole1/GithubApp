package ru.spitchenko.githubapp.feature.github.search.domain

import javax.inject.Inject

class RemoveFromFavorites @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {

    suspend operator fun invoke(repositoryId: Long) {
        favoritesRepository.removeFromFavorites(repositoryId)
    }
}
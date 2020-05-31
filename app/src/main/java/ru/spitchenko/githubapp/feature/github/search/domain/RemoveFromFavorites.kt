package ru.spitchenko.githubapp.feature.github.search.domain

class RemoveFromFavorites(private val favoritesRepository: FavoritesRepository) {

    suspend operator fun invoke(repositoryId: Long) {
        favoritesRepository.removeFromFavorites(repositoryId)
    }
}
package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

class AddToFavorites @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {

    suspend operator fun invoke(repository: Repository) {
        favoritesRepository.addToFavorite(repository)
    }
}
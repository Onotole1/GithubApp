package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository

class GetFavorites(
    private val favoritesRepository: FavoritesRepository
) {

    suspend operator fun invoke(repositories: List<Repository>) =
        favoritesRepository.getFavorites(repositories)
}
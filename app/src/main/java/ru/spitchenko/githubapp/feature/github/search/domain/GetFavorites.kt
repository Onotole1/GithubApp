package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

class GetFavorites @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {

    suspend operator fun invoke(repositories: List<Repository>) =
        favoritesRepository.getFavorites(repositories)
}
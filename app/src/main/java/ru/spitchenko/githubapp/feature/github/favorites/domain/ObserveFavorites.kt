package ru.spitchenko.githubapp.feature.github.favorites.domain

import kotlinx.coroutines.flow.Flow
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

class ObserveFavorites @Inject constructor(private val repository: ObserveFavoritesRepository) {

    operator fun invoke(): Flow<List<Repository>> =
        repository.observe()
}
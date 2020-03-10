package ru.spitchenko.githubapp.feature.github.favorites.domain

import kotlinx.coroutines.flow.Flow
import ru.spitchenko.githubapp.feature.github.domain.model.Repository

interface ObserveFavoritesRepository {

    fun observe(): Flow<List<Repository>>
}
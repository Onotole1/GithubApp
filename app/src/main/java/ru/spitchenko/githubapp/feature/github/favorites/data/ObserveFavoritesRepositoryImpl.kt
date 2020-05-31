package ru.spitchenko.githubapp.feature.github.favorites.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.spitchenko.githubapp.feature.github.data.RepositoriesDao
import ru.spitchenko.githubapp.feature.github.data.RepositoryEntitiesConverter
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.favorites.domain.ObserveFavoritesRepository

class ObserveFavoritesRepositoryImpl(
    private val repositoriesDao: RepositoriesDao,
    private val converter: RepositoryEntitiesConverter
) : ObserveFavoritesRepository {

    override fun observe(): Flow<List<Repository>> = repositoriesDao.observe().map {
        converter.convert(it)
    }
}
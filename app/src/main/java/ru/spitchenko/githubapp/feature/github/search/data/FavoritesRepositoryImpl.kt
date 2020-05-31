package ru.spitchenko.githubapp.feature.github.search.data

import ru.spitchenko.githubapp.feature.github.data.RepositoriesDao
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.data.RepositoryEntitiesConverter
import ru.spitchenko.githubapp.feature.github.search.domain.FavoritesRepository

class FavoritesRepositoryImpl(
    private val dao: RepositoriesDao,
    private val entityConverter: RepositoryEntityConverter,
    private val entitiesConverter: RepositoryEntitiesConverter
): FavoritesRepository {

    override suspend fun addToFavorite(repository: Repository) {
        dao.insertOrUpdate(entityConverter.convert(repository))
    }

    override suspend fun removeFromFavorites(repositoryId: Long) {
        dao.deleteById(repositoryId)
    }

    override suspend fun getFavorites(repositories: List<Repository>): List<Repository> =
        dao.getByIds(repositories.map {
            it.id
        }).let {
            entitiesConverter.convert(it)
        }
}
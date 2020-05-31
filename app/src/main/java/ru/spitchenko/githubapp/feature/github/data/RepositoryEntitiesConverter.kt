package ru.spitchenko.githubapp.feature.github.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.spitchenko.githubapp.feature.github.domain.model.Author
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.domain.model.SimpleRepository

object RepositoryEntitiesConverter {

    suspend fun convert(entities: List<RepositoryEntity>): List<Repository> =
        withContext(Dispatchers.Default) {
            entities.map { entity ->
                SimpleRepository(
                    id = entity.id,
                    name = entity.name,
                    author = Author(
                        login = entity.authorLogin,
                        avatar = entity.authorAvatar
                    ),
                    description = entity.description,
                    forks = entity.forks,
                    stars = entity.stars,
                    creationDate = entity.creationDate
                )
            }
        }
}
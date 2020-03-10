package ru.spitchenko.githubapp.feature.github.search.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import ru.spitchenko.githubapp.feature.github.domain.model.Author
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.domain.model.SimpleRepository
import ru.spitchenko.githubapp.feature.github.search.data.model.SearchRepositoryDto
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class SearchRepositoryDtoConverter @Inject constructor() {

    private val serverTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.US)

    private val mutex = Mutex()

    suspend fun convert(dto: SearchRepositoryDto): List<Repository> =
        withContext(Dispatchers.Default) {
            dto.items.map { repositoryDto ->
                val author = Author(
                    login = repositoryDto.owner?.login.orEmpty(),
                    avatar = repositoryDto.owner?.avatarUrl
                )

                SimpleRepository(
                    id = repositoryDto.id,
                    name = repositoryDto.name.orEmpty(),
                    author = author,
                    description = repositoryDto.description.orEmpty(),
                    forks = repositoryDto.forks ?: 0,
                    stars = repositoryDto.stargazersCount ?: 0,
                    creationDate = mutex.withLock {
                        requireNotNull(
                            serverTimeFormat.parse(
                                requireNotNull(repositoryDto.createdAt)
                            )
                        ).time
                    }
                )
            }
        }
}
package ru.spitchenko.githubapp.feature.github.search.data

import ru.spitchenko.githubapp.feature.github.data.RepositoryEntity
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

class RepositoryEntityConverter @Inject constructor() {

    fun convert(repository: Repository): RepositoryEntity =
        RepositoryEntity(
            id = repository.id,
            name = repository.name,
            authorLogin = repository.author.login,
            authorAvatar = repository.author.avatar,
            description = repository.description,
            forks = repository.forks,
            stars = repository.stars,
            creationDate = repository.creationDate
        )
}
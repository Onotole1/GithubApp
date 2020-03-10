package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

class Search @Inject constructor(private val repository: SearchRepository) {

    suspend operator fun invoke(query: String, perPage: Int, page: Int): List<Repository> =
        repository.search(query, page = page, perPage = perPage)
}
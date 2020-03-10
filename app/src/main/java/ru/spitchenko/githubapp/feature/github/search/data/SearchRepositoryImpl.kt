package ru.spitchenko.githubapp.feature.github.search.data

import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import ru.spitchenko.githubapp.feature.github.search.domain.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: SearchApi,
    private val converter: SearchRepositoryDtoConverter
) : SearchRepository {

    override suspend fun search(query: String, page: Int, perPage: Int): List<Repository> =
        api.search(query, page, perPage).let {
            converter.convert(it)
        }
}
package ru.spitchenko.githubapp.feature.github.search.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Search @Inject constructor(
    private val getFavorites: GetFavorites,
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String, perPage: Int, page: Int): List<FavoriteRepository> =
        repository.search(query, page = page, perPage = perPage).let { found ->
            val favorites = getFavorites(found)

            withContext(Dispatchers.Default) {
                found.map {  repository ->
                    FavoriteRepository(repository, favorites.contains(repository))
                }
            }
        }
}
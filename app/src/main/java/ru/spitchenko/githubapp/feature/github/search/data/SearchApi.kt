package ru.spitchenko.githubapp.feature.github.search.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.spitchenko.githubapp.feature.github.search.data.model.SearchRepositoryDto

interface SearchApi {

    @GET("search/repositories")
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc"
    ): SearchRepositoryDto
}
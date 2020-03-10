package ru.spitchenko.githubapp.feature.github.search.domain

import ru.spitchenko.githubapp.feature.github.domain.model.Repository

interface SearchRepository {

    suspend fun search(query: String, page: Int, perPage: Int): List<Repository>
}
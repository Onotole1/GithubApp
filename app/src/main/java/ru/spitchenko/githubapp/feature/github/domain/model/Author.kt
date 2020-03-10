package ru.spitchenko.githubapp.feature.github.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val login: String,
    val avatar: String?
)
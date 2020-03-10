package ru.spitchenko.githubapp.feature.github.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SimpleRepository(
    override val id: Long,
    override val name: String,
    override val author: Author,
    override val description: String,
    override val forks: Int,
    override val stars: Int,
    override val creationDate: Long
): Repository
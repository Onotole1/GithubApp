package ru.spitchenko.githubapp.feature.github.domain.model

interface Repository {
    val id: Long
    val name: String
    val author: Author
    val description: String
    val forks: Int
    val stars: Int
    val creationDate: Long
}
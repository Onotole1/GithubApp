package ru.spitchenko.githubapp.feature.github.data

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "repository",
    indices = [
        Index("id")
    ],
    primaryKeys = [
        "id"
    ]
)
data class RepositoryEntity(
    val id: Long,
    val name: String,
    val authorLogin: String,
    val authorAvatar: String?,
    val description: String,
    val forks: Int,
    val stars: Int,
    val creationDate: Long
)
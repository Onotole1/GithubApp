package ru.spitchenko.githubapp.feature.github.domain

interface LogoutRepository {

    suspend fun logout()
}
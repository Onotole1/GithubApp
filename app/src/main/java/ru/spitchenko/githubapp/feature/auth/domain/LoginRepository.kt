package ru.spitchenko.githubapp.feature.auth.domain

interface LoginRepository {

    fun login(email: String)
    fun isUserLoggedIn(): Boolean
}
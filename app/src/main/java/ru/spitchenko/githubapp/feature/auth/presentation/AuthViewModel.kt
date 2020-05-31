package ru.spitchenko.githubapp.feature.auth.presentation

import ru.spitchenko.githubapp.feature.auth.domain.Login

class AuthViewModel(
    private val login: Login
) {

    fun login(email: String) {
        login.invoke(email)
    }
}
package ru.spitchenko.githubapp.feature.auth.presentation

import ru.spitchenko.githubapp.feature.auth.domain.Login
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val login: Login) {

    fun login(email: String) {
        login.invoke(email)
    }
}
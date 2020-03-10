package ru.spitchenko.githubapp.feature.auth.presentation

import ru.spitchenko.githubapp.feature.auth.domain.Login
import ru.spitchenko.githubapp.feature.auth.navigation.AuthToGithubCommand
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val login: Login,
    private val authToGithubCommand: AuthToGithubCommand
) {

    fun login(email: String) {
        login.invoke(email)
        authToGithubCommand.navigate()
    }
}
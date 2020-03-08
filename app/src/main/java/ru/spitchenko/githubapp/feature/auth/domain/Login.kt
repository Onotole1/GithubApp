package ru.spitchenko.githubapp.feature.auth.domain

import javax.inject.Inject

class Login @Inject constructor(private val loginRepository: LoginRepository) {

    operator fun invoke(email: String) {
        loginRepository.login(email)
    }
}
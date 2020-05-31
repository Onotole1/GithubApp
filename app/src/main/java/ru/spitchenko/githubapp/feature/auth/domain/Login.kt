package ru.spitchenko.githubapp.feature.auth.domain

class Login(private val loginRepository: LoginRepository) {

    operator fun invoke(email: String) {
        loginRepository.login(email)
    }
}
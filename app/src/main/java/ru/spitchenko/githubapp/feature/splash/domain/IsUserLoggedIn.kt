package ru.spitchenko.githubapp.feature.splash.domain

import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository

class IsUserLoggedIn(private val loginRepository: LoginRepository) {

    operator fun invoke(): Boolean = loginRepository.isUserLoggedIn()
}
package ru.spitchenko.githubapp.feature.splash.domain

import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository
import javax.inject.Inject

class IsUserLoggedIn @Inject constructor(private val loginRepository: LoginRepository) {

    operator fun invoke(): Boolean = loginRepository.isUserLoggedIn()
}
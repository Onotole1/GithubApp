package ru.spitchenko.githubapp.feature.github.domain

import javax.inject.Inject

class Logout @Inject constructor(private val repository: LogoutRepository) {

    suspend operator fun invoke() {
        repository.logout()
    }
}
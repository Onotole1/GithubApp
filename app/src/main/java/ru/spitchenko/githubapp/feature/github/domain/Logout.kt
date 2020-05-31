package ru.spitchenko.githubapp.feature.github.domain

class Logout(private val repository: LogoutRepository) {

    suspend operator fun invoke() {
        repository.logout()
    }
}
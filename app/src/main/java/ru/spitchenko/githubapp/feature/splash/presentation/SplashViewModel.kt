package ru.spitchenko.githubapp.feature.splash.presentation

import ru.spitchenko.githubapp.feature.splash.domain.IsUserLoggedIn
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToAuthCommand
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToGithubCommand
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val isUserLoggedIn: IsUserLoggedIn,
    private val splashToAuthCommand: SplashToAuthCommand,
    private val splashToGithubCommand: SplashToGithubCommand
) {

    fun navigate() {
        if (isUserLoggedIn()) {
            splashToGithubCommand.navigate()
        } else {
            splashToAuthCommand.navigate()
        }
    }
}
package ru.spitchenko.githubapp.feature.splash.presentation

import ru.spitchenko.githubapp.feature.splash.domain.IsUserLoggedIn

class SplashViewModel(private val isUserLoggedIn: IsUserLoggedIn) {

    fun navigate(): SplashNavigation =
        if (isUserLoggedIn()) {
            SplashNavigation.ToGithub
        } else {
            SplashNavigation.ToLogin
        }
}
package ru.spitchenko.githubapp.feature.splash.presentation

sealed class SplashNavigation {

    object ToLogin : SplashNavigation()
    object ToGithub : SplashNavigation()
}
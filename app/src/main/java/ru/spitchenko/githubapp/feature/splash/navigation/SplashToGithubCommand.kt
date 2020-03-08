package ru.spitchenko.githubapp.feature.splash.navigation

import android.app.Activity
import ru.spitchenko.githubapp.component.navigation.Navigator
import ru.spitchenko.githubapp.component.navigation.SplashToGithub
import javax.inject.Inject

interface SplashToGithubCommand {

    fun navigate()
}

class SplashToGithubCommandImpl @Inject constructor(
    private val navigator: Navigator<Activity>
) : SplashToGithubCommand {

    override fun navigate() {
        navigator.navigate(SplashToGithub)
    }
}
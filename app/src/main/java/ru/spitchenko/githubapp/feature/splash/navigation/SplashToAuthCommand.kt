package ru.spitchenko.githubapp.feature.splash.navigation

import android.app.Activity
import ru.spitchenko.githubapp.component.navigation.Navigator
import ru.spitchenko.githubapp.component.navigation.SplashToAuth
import javax.inject.Inject

interface SplashToAuthCommand {

    fun navigate()
}

class SplashToAuthCommandImpl @Inject constructor(
    private val navigator: Navigator<Activity>
) : SplashToAuthCommand {

    override fun navigate() {
        navigator.navigate(SplashToAuth)
    }
}
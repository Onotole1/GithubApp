package ru.spitchenko.githubapp.feature.auth.navigation

import android.app.Activity
import ru.spitchenko.githubapp.component.navigation.AuthToGithub
import ru.spitchenko.githubapp.component.navigation.Navigator
import ru.spitchenko.githubapp.component.navigation.SplashToGithub
import javax.inject.Inject

interface AuthToGithubCommand {

    fun navigate()
}

class AuthToGithubCommandImpl @Inject constructor(
    private val navigator: Navigator<Activity>
) : AuthToGithubCommand {

    override fun navigate() {
        navigator.navigate(AuthToGithub)
    }
}
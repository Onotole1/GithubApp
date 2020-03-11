package ru.spitchenko.githubapp.feature.github.navigation

import android.app.Activity
import ru.spitchenko.githubapp.component.navigation.Logout
import ru.spitchenko.githubapp.component.navigation.Navigator
import javax.inject.Inject

interface LogoutCommand {

    fun navigate()
}

class LogoutCommandImpl @Inject constructor(
    private val navigator: Navigator<Activity>
): LogoutCommand {

    override fun navigate() {
        navigator.navigate(Logout)
    }
}
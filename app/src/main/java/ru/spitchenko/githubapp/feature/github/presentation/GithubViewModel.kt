package ru.spitchenko.githubapp.feature.github.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.spitchenko.githubapp.feature.github.domain.Logout
import ru.spitchenko.githubapp.feature.github.navigation.LogoutCommand
import javax.inject.Inject

class GithubViewModel @Inject constructor(
    private val logout: Logout,
    private val logoutCommand: LogoutCommand
) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            logout.invoke()
            logoutCommand.navigate()
        }
    }
}
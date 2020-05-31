package ru.spitchenko.githubapp.feature.github.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.spitchenko.githubapp.component.lifecycle.MutableSingleLiveEvent
import ru.spitchenko.githubapp.component.lifecycle.SingleLiveEvent
import ru.spitchenko.githubapp.component.lifecycle.call
import ru.spitchenko.githubapp.feature.github.domain.Logout

class GithubViewModel(
    private val logout: Logout
) : ViewModel() {

    private val _logoutEvent = MutableSingleLiveEvent<Unit>()
    val logoutEvent: SingleLiveEvent<Unit>
        get() = _logoutEvent

    fun logout() {
        viewModelScope.launch {
            logout.invoke()
            _logoutEvent.call()
        }
    }
}
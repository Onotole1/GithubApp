package ru.spitchenko.githubapp.feature.auth.data

import android.content.SharedPreferences
import ru.spitchenko.githubapp.component.preferences.string
import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository

class LoginRepositoryImpl(
    sharedPreferences: SharedPreferences
) : LoginRepository {

    private var login by sharedPreferences.string()

    override fun login(email: String) {
        login = email
    }

    override fun isUserLoggedIn(): Boolean = !login.isNullOrBlank()

    override fun logout() {
        login = null
    }
}
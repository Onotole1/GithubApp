package ru.spitchenko.githubapp.feature.auth.data

import android.content.SharedPreferences
import ru.spitchenko.githubapp.component.preferences.string
import ru.spitchenko.githubapp.feature.auth.di.AuthPreferences
import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    @AuthPreferences sharedPreferences: SharedPreferences
) : LoginRepository {

    private var login by sharedPreferences.string()

    override fun login(email: String) {
        login = email
    }

    override fun isUserLoggedIn(): Boolean = !login.isNullOrBlank()
}
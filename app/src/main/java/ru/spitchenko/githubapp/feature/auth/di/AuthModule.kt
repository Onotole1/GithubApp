package ru.spitchenko.githubapp.feature.auth.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module
import ru.spitchenko.githubapp.feature.auth.data.LoginRepositoryImpl
import ru.spitchenko.githubapp.feature.auth.domain.Login
import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository
import ru.spitchenko.githubapp.feature.auth.presentation.AuthFragment
import ru.spitchenko.githubapp.feature.auth.presentation.AuthViewModel
import ru.spitchenko.githubapp.feature.auth.presentation.GoogleSignInContract

private const val AUTH_PREFERENCES = "auth_preferences"

val authModule = module {
    factory<LoginRepository> {
        val authPreferences =
            androidContext().getSharedPreferences(AUTH_PREFERENCES, Context.MODE_PRIVATE)

        LoginRepositoryImpl(authPreferences)
    }

    factory { Login(get()) }

    factory { AuthViewModel(get()) }

    fragment {
        val googleSignInContract = GoogleSignInContract(get())
        AuthFragment(signInContract = googleSignInContract, viewModel = get())
    }
}
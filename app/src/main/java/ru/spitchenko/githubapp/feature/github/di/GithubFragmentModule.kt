package ru.spitchenko.githubapp.feature.github.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.spitchenko.githubapp.feature.github.data.LogoutRepositoryImpl
import ru.spitchenko.githubapp.feature.github.domain.Logout
import ru.spitchenko.githubapp.feature.github.domain.LogoutRepository
import ru.spitchenko.githubapp.feature.github.presentation.GithubViewModel

val githubFragmentModule = module {
    factory<LogoutRepository> {
        LogoutRepositoryImpl(
            repositoriesDao = get(),
            loginRepository = get(),
            googleSignInClient = get()
        )
    }

    factory { Logout(get()) }

    viewModel {
        GithubViewModel(get())
    }
}
package ru.spitchenko.githubapp.feature.splash.di

import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module
import ru.spitchenko.githubapp.feature.splash.domain.IsUserLoggedIn
import ru.spitchenko.githubapp.feature.splash.presentation.SplashFragment
import ru.spitchenko.githubapp.feature.splash.presentation.SplashViewModel

val splashModule = module {
    factory { IsUserLoggedIn(get()) }

    factory { SplashViewModel(get()) }

    fragment { SplashFragment(get()) }
}
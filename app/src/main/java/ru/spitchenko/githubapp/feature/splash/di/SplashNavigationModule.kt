package ru.spitchenko.githubapp.feature.splash.di

import dagger.Binds
import dagger.Module
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToAuthCommand
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToAuthCommandImpl
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToGithubCommand
import ru.spitchenko.githubapp.feature.splash.navigation.SplashToGithubCommandImpl

@Module
interface SplashNavigationModule {

    @Binds
    fun bindSplashToAuthCommand(impl: SplashToAuthCommandImpl): SplashToAuthCommand

    @Binds
    fun bindSplashToGithubCommand(impl: SplashToGithubCommandImpl): SplashToGithubCommand
}
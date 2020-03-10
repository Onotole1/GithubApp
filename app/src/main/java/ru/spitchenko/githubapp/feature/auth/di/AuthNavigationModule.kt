package ru.spitchenko.githubapp.feature.auth.di

import dagger.Binds
import dagger.Module
import ru.spitchenko.githubapp.feature.auth.navigation.AuthToGithubCommand
import ru.spitchenko.githubapp.feature.auth.navigation.AuthToGithubCommandImpl

@Module
interface AuthNavigationModule {

    @Binds
    fun bindAuthToGithubCommand(impl: AuthToGithubCommandImpl): AuthToGithubCommand
}
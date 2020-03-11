package ru.spitchenko.githubapp.feature.github.di

import dagger.Binds
import dagger.Module
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommand
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommandImpl

@Module
interface GithubNavigationModule {

    @Binds
    fun bindGithubToDetailsCommand(impl: GithubToDetailsCommandImpl): GithubToDetailsCommand
}
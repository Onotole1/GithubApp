package ru.spitchenko.githubapp.feature.github.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.spitchenko.githubapp.feature.github.favorites.di.FavoritesModule
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesFragment
import ru.spitchenko.githubapp.feature.github.search.di.SearchModule
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchFragment

@Module
interface GithubFragmentModule {

    @ContributesAndroidInjector(
        modules = [
            FavoritesModule::class,
            GithubNavigationModule::class
        ]
    )
    fun favoritesFragmentInjector(): FavoritesFragment

    @ContributesAndroidInjector(
        modules = [
            SearchModule::class,
            GithubNavigationModule::class
        ]
    )
    fun searchInjector(): SearchFragment
}
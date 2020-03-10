package ru.spitchenko.githubapp.feature.github.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesFragment
import ru.spitchenko.githubapp.feature.github.search.di.SearchModule
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchFragment

@Module
interface GithubFragmentModule {

    @ContributesAndroidInjector
    fun favoritesFragmentInjector(): FavoritesFragment

    @ContributesAndroidInjector(
        modules = [
            SearchModule::class
        ]
    )
    fun searchInjector(): SearchFragment
}
package ru.spitchenko.githubapp.feature.github.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.spitchenko.githubapp.component.di.ViewModelKey
import ru.spitchenko.githubapp.feature.github.data.LogoutRepositoryImpl
import ru.spitchenko.githubapp.feature.github.domain.LogoutRepository
import ru.spitchenko.githubapp.feature.github.favorites.di.FavoritesModule
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesFragment
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommand
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommandImpl
import ru.spitchenko.githubapp.feature.github.navigation.LogoutCommand
import ru.spitchenko.githubapp.feature.github.navigation.LogoutCommandImpl
import ru.spitchenko.githubapp.feature.github.presentation.GithubViewModel
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

    @Binds
    fun bindLogoutCommand(impl: LogoutCommandImpl): LogoutCommand

    @Binds
    fun bindLogoutRepository(impl: LogoutRepositoryImpl): LogoutRepository

    @ViewModelKey(GithubViewModel::class)
    @IntoMap
    @Binds
    fun bindGithubViewModel(impl: GithubViewModel): ViewModel
}
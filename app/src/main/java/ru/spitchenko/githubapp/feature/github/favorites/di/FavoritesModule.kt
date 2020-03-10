package ru.spitchenko.githubapp.feature.github.favorites.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.spitchenko.githubapp.component.di.ViewModelKey
import ru.spitchenko.githubapp.feature.github.favorites.data.ObserveFavoritesRepositoryImpl
import ru.spitchenko.githubapp.feature.github.favorites.domain.ObserveFavoritesRepository
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesViewModel

@Module
interface FavoritesModule {

    @Binds
    fun bindObserveFavoritesRepository(impl: ObserveFavoritesRepositoryImpl): ObserveFavoritesRepository

    @ViewModelKey(FavoritesViewModel::class)
    @IntoMap
    @Binds
    fun bindFavoritesViewModel(impl: FavoritesViewModel): ViewModel
}
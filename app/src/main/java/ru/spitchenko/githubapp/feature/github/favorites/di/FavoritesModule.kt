package ru.spitchenko.githubapp.feature.github.favorites.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.spitchenko.githubapp.feature.github.data.RepositoryEntitiesConverter
import ru.spitchenko.githubapp.feature.github.favorites.data.ObserveFavoritesRepositoryImpl
import ru.spitchenko.githubapp.feature.github.favorites.domain.ObserveFavorites
import ru.spitchenko.githubapp.feature.github.favorites.domain.ObserveFavoritesRepository
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesViewModel

val favoritesModule = module {

    factory<ObserveFavoritesRepository> {
        ObserveFavoritesRepositoryImpl(
            repositoriesDao = get(),
            converter = RepositoryEntitiesConverter
        )
    }

    factory { ObserveFavorites(get()) }

    viewModel { FavoritesViewModel(get()) }
}
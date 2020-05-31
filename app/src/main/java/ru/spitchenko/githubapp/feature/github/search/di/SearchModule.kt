package ru.spitchenko.githubapp.feature.github.search.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import ru.spitchenko.githubapp.feature.github.data.RepositoryEntitiesConverter
import ru.spitchenko.githubapp.feature.github.search.data.*
import ru.spitchenko.githubapp.feature.github.search.domain.*
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchViewModel

val searchModule = module {
    factory { get<Retrofit>().create<SearchApi>() }

    factory<SearchRepository> { SearchRepositoryImpl(api = get(), converter = SearchRepositoryDtoConverter) }

    factory<FavoritesRepository> {
        FavoritesRepositoryImpl(
            dao = get(),
            entityConverter = RepositoryEntityConverter,
            entitiesConverter = RepositoryEntitiesConverter
        )
    }

    factory { RemoveFromFavorites(get()) }

    factory { AddToFavorites(get()) }

    factory { GetFavorites(get()) }

    factory { Search(getFavorites = get(), repository = get()) }

    viewModel {
        SearchViewModel(search = get(), addToFavorites = get(), removeFromFavorites = get())
    }
}
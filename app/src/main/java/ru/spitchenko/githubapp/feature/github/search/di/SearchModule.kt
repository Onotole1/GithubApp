package ru.spitchenko.githubapp.feature.github.search.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.create
import ru.spitchenko.githubapp.component.di.ViewModelKey
import ru.spitchenko.githubapp.feature.github.search.data.FavoritesRepositoryImpl
import ru.spitchenko.githubapp.feature.github.search.data.SearchApi
import ru.spitchenko.githubapp.feature.github.search.data.SearchRepositoryImpl
import ru.spitchenko.githubapp.feature.github.search.domain.FavoritesRepository
import ru.spitchenko.githubapp.feature.github.search.domain.SearchRepository
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchViewModel

@Module
interface SearchModule {

    companion object {

        @Provides
        fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create()
    }

    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    @Binds
    fun bindFavoritesRepository(impl: FavoritesRepositoryImpl): FavoritesRepository

    @ViewModelKey(SearchViewModel::class)
    @IntoMap
    @Binds
    fun bindSearchViewModel(impl: SearchViewModel): ViewModel
}
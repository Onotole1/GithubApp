package ru.spitchenko.githubapp.feature.auth.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.spitchenko.githubapp.feature.auth.data.LoginRepositoryImpl
import ru.spitchenko.githubapp.feature.auth.domain.LoginRepository

@Module
interface AuthModule {

    companion object {

        private const val AUTH_PREFERENCES = "auth_preferences"

        @AuthPreferences
        @Provides
        fun provideAuthPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(AUTH_PREFERENCES, Context.MODE_PRIVATE)
    }

    @Binds
    fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository
}
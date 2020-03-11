package ru.spitchenko.githubapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.spitchenko.githubapp.AppActivity
import ru.spitchenko.githubapp.component.database.di.DatabaseModule
import ru.spitchenko.githubapp.component.di.ActivityScope
import ru.spitchenko.githubapp.component.navigation.ActivityNavigationModule
import ru.spitchenko.githubapp.component.network.di.NetworkModule
import ru.spitchenko.githubapp.feature.auth.di.AuthModule

@Module(
    includes = [
        NetworkModule::class,
        DatabaseModule::class,
        AndroidSupportInjectionModule::class
    ]
)
internal interface ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            AuthModule::class,
            AppActivityModule::class,
            ActivityNavigationModule::class
        ]
    )
    fun appActivityInjector(): AppActivity
}
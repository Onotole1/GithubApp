package ru.spitchenko.githubapp.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.spitchenko.githubapp.AppActivity
import ru.spitchenko.githubapp.component.di.FragmentScope
import ru.spitchenko.githubapp.feature.auth.di.AuthModule
import ru.spitchenko.githubapp.feature.auth.di.GoogleAuthModule
import ru.spitchenko.githubapp.feature.auth.presentation.AuthFragment
import ru.spitchenko.githubapp.feature.github.di.GithubFragmentModule
import ru.spitchenko.githubapp.feature.github.presentation.GithubFragment
import ru.spitchenko.githubapp.feature.splash.presentation.SplashFragment
import ru.spitchenko.githubapp.feature.splash.di.SplashNavigationModule

@Module
interface AppActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            AuthModule::class,
            SplashNavigationModule::class
        ]
    )
    fun splashFragmentInjector(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            AuthModule::class,
            GoogleAuthModule::class
        ]
    )
    fun authFragmentInjector(): AuthFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            GithubFragmentModule::class
        ]
    )
    fun githubFragmentInjector(): GithubFragment

    @Binds
    fun bindAppCompatActivity(activity: AppActivity): AppCompatActivity
}
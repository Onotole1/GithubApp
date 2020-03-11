package ru.spitchenko.githubapp.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.spitchenko.githubapp.AppActivity
import ru.spitchenko.githubapp.component.di.FragmentScope
import ru.spitchenko.githubapp.feature.auth.di.AuthNavigationModule
import ru.spitchenko.githubapp.feature.auth.di.GoogleAuthModule
import ru.spitchenko.githubapp.feature.auth.presentation.AuthFragment
import ru.spitchenko.githubapp.feature.github.di.GithubFragmentModule
import ru.spitchenko.githubapp.feature.github.presentation.GithubFragment
import ru.spitchenko.githubapp.feature.splash.di.SplashNavigationModule
import ru.spitchenko.githubapp.feature.splash.presentation.SplashFragment

@Module
interface AppActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            SplashNavigationModule::class
        ]
    )
    fun splashFragmentInjector(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            GoogleAuthModule::class,
            AuthNavigationModule::class
        ]
    )
    fun authFragmentInjector(): AuthFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            GoogleAuthModule::class,
            GithubFragmentModule::class
        ]
    )
    fun githubFragmentInjector(): GithubFragment

    @Binds
    fun bindAppCompatActivity(activity: AppActivity): AppCompatActivity
}
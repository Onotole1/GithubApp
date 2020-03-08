package ru.spitchenko.githubapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.spitchenko.githubapp.AppActivity
import ru.spitchenko.githubapp.component.di.ActivityScope
import ru.spitchenko.githubapp.component.navigation.ActivityNavigationModule

@Module(
    includes = [
        AndroidSupportInjectionModule::class
    ]
)
internal interface ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            AppActivityModule::class,
            ActivityNavigationModule::class
        ]
    )
    fun appActivityInjector(): AppActivity
}
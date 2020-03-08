package ru.spitchenko.githubapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.spitchenko.githubapp.di.DaggerApplicationComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.factory()
            .create(this)
}
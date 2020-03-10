package ru.spitchenko.githubapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.spitchenko.githubapp.di.DaggerApplicationComponent
import timber.log.Timber

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.factory()
            .create(this)

    override fun onCreate() {
        super.onCreate()

        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package ru.spitchenko.githubapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.spitchenko.githubapp.component.database.di.databaseModule
import ru.spitchenko.githubapp.component.network.di.networkModule
import ru.spitchenko.githubapp.feature.auth.di.authModule
import ru.spitchenko.githubapp.feature.auth.di.googleAuthModule
import ru.spitchenko.githubapp.feature.github.di.githubFragmentModule
import ru.spitchenko.githubapp.feature.github.favorites.di.favoritesModule
import ru.spitchenko.githubapp.feature.github.search.di.searchModule
import ru.spitchenko.githubapp.feature.splash.di.splashModule
import timber.log.Timber
import org.koin.androidx.fragment.koin.fragmentFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupLogging()

        startKoin {
            androidContext(this@App)

            fragmentFactory()

            modules(
                authModule,
                splashModule,
                googleAuthModule,
                searchModule,
                githubFragmentModule,
                favoritesModule,
                networkModule,
                databaseModule
            )
        }
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package ru.spitchenko.githubapp

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.android.ext.koin.androidContext
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules
import ru.spitchenko.githubapp.component.database.di.databaseModule
import ru.spitchenko.githubapp.component.network.di.networkModule
import ru.spitchenko.githubapp.feature.auth.di.authModule
import ru.spitchenko.githubapp.feature.auth.di.googleAuthModule
import ru.spitchenko.githubapp.feature.github.di.githubFragmentModule
import ru.spitchenko.githubapp.feature.github.favorites.di.favoritesModule
import ru.spitchenko.githubapp.feature.github.search.di.searchModule
import ru.spitchenko.githubapp.feature.splash.di.splashModule

@Category(CheckModuleTest::class)
class CheckModules {

    @Test
    fun checkAppModule() = checkModules {
        androidContext(InstrumentationRegistry.getInstrumentation().targetContext)

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
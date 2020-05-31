package ru.spitchenko.githubapp.component.database.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.spitchenko.githubapp.feature.github.data.DATABASE_NAME
import ru.spitchenko.githubapp.feature.github.data.Database

val databaseModule = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    factory {
        get<Database>().getRepositoriesDao()
    }
}
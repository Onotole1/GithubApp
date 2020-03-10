package ru.spitchenko.githubapp.component.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.spitchenko.githubapp.component.di.ApplicationScope
import ru.spitchenko.githubapp.feature.github.data.DATABASE_NAME
import ru.spitchenko.githubapp.feature.github.data.Database
import ru.spitchenko.githubapp.feature.github.data.RepositoriesDao

@Module
class DatabaseModule {

    @ApplicationScope
    @Provides
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java,
                DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()

    @ApplicationScope
    @Provides
    fun provideRepositoryDao(database: Database): RepositoriesDao = database.getRepositoriesDao()
}
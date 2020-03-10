package ru.spitchenko.githubapp.feature.github.data

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "repositories_database"
private const val DATABASE_VERSION = 1

@Database(
    entities = [
        RepositoryEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class Database : RoomDatabase() {

    abstract fun getRepositoriesDao(): RepositoriesDao
}
package ru.spitchenko.githubapp.feature.github.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RepositoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(value: RepositoryEntity)

    @Query("SELECT * FROM repository")
    fun observe(): Flow<List<RepositoryEntity>>

    @Query(value = "DELETE FROM repository")
    suspend fun deleteAll()

    @Query("DELETE FROM repository WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT * FROM repository WHERE id IN (:ids)")
    suspend fun getByIds(ids: List<Long>): List<RepositoryEntity>
}
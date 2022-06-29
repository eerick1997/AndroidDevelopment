package com.eerick.doggosmvvm.domain.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eerick.doggosmvvm.domain.data.database.entity.DogEntity

@Dao
interface DogDao {
    @Query("SELECT * FROM dog_table")
    suspend fun getAllDogs(): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogs: List<DogEntity>)

    @Query("DELETE FROM dog_table")
    suspend fun deleteAll()
}
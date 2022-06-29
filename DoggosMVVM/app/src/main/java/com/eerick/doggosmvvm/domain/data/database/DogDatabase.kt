package com.eerick.doggosmvvm.domain.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eerick.doggosmvvm.domain.data.database.dao.DogDao
import com.eerick.doggosmvvm.domain.data.database.entity.DogEntity

@Database(entities = [DogEntity::class], version = 1)
abstract class DogDatabase : RoomDatabase(){
    abstract fun getDogDao() : DogDao
}
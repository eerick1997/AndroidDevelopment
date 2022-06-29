package com.eerick.learningmvvm.domain.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eerick.learningmvvm.domain.data.database.dao.QuoteDao
import com.eerick.learningmvvm.domain.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}
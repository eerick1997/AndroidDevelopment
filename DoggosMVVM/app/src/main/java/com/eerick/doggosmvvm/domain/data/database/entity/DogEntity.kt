package com.eerick.doggosmvvm.domain.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eerick.doggosmvvm.domain.model.Dog

@Entity(tableName = "dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "image") val image: String
)

fun Dog.toEntity() = DogEntity(name = name, description = description, age = age, image = image)
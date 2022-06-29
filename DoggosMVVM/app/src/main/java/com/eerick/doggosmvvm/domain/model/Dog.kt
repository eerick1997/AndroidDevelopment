package com.eerick.doggosmvvm.domain.model

import com.eerick.doggosmvvm.domain.data.database.entity.DogEntity
import com.eerick.doggosmvvm.domain.data.model.DogModel

data class Dog(val name: String, val description: String, val age: Int, val image: String)

fun DogModel.toDomain() = Dog(name = name, description = description, age = age, image = image)
fun DogEntity.toDomain() = Dog(name = name, description = description, age = age, image = image)

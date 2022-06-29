package com.eerick.doggosmvvm.domain.data

import com.eerick.doggosmvvm.domain.data.database.dao.DogDao
import com.eerick.doggosmvvm.domain.data.database.entity.DogEntity
import com.eerick.doggosmvvm.domain.data.network.DogService
import com.eerick.doggosmvvm.domain.model.Dog
import com.eerick.doggosmvvm.domain.model.toDomain
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val API: DogService,
    private val dogDao: DogDao
){
    suspend fun getAllDogsFromApi() : List<Dog> {
        val response = API.getDogs()
        return response.map {dogModel -> dogModel.toDomain()}
    }

    suspend fun getAllDogsFromDatabase() : List<Dog> {
        val response = dogDao.getAllDogs()
        return response.map { dogEntity -> dogEntity.toDomain() }
    }

    suspend fun insertDogs(dogs: List<DogEntity>) {
        dogDao.insertAll(dogs)
    }

    suspend fun clearDogs() {
        dogDao.deleteAll()
    }
}
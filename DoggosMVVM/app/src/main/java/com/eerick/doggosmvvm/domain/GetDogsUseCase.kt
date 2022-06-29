package com.eerick.doggosmvvm.domain

import com.eerick.doggosmvvm.domain.data.DogsRepository
import com.eerick.doggosmvvm.domain.data.database.entity.toEntity
import com.eerick.doggosmvvm.domain.model.Dog
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val repository: DogsRepository){
    suspend operator fun invoke(): List<Dog> {
        val dogs = repository.getAllDogsFromApi()
        if (dogs.isNotEmpty()) {
            repository.clearDogs()
            repository.insertDogs(dogs.map {dog -> dog.toEntity() })
            return dogs
        }
        return repository.getAllDogsFromDatabase()
    }
}
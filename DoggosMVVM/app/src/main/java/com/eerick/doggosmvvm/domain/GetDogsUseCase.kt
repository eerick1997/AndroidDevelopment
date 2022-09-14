package com.eerick.doggosmvvm.domain

import android.util.Log
import com.eerick.doggosmvvm.domain.data.DogsRepository
import com.eerick.doggosmvvm.domain.data.database.entity.toEntity
import com.eerick.doggosmvvm.domain.data.network.NoConnectivityException
import com.eerick.doggosmvvm.domain.model.Dog
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val repository: DogsRepository){

    private val TAG = "GetDogsUseCase"

    suspend operator fun invoke(): List<Dog> {
        try {
            val dogs = repository.getAllDogsFromApi()
            if (dogs.isNotEmpty()) {
                repository.clearDogs()
                repository.insertDogs(dogs.map {dog -> dog.toEntity() })
                return dogs
            }
        } catch (e: NoConnectivityException) {
            Log.e(TAG, "invoke: ", e)
        }
        return repository.getAllDogsFromDatabase()
    }
}
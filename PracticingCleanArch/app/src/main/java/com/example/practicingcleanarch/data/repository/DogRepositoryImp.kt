package com.example.practicingcleanarch.data.repository

import com.example.practicingcleanarch.data.data_source.remote.DogsAPI
import com.example.practicingcleanarch.domain.repository.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepositoryImp @Inject constructor(
    private val dogsAPI: DogsAPI
) : DogRepository {
    override suspend fun getAllDogs() : List<String> {
        return withContext(Dispatchers.IO) {
            val response = dogsAPI.getDogs()
            val body = response.body()
            body?.message ?: emptyList()
        }
    }
}
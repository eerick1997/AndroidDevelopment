package com.example.practicingcleanarch2.data.repository

import com.example.practicingcleanarch2.data.remote.DogsAPI
import com.example.practicingcleanarch2.domain.repository.DogsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogsRepositoryImp @Inject constructor(
    private val dogsAPI: DogsAPI
) : DogsRepository {
    override suspend fun getDogsFromApi(): List<String> {
        return withContext(Dispatchers.IO) {
            val response = dogsAPI.getAllDogs()
            val body = response.body()
            body?.message ?: emptyList()
        }
    }
}
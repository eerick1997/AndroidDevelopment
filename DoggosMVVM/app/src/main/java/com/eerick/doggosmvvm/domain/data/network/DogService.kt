package com.eerick.doggosmvvm.domain.data.network

import com.eerick.doggosmvvm.domain.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val apiClient: DogApiClient) {
    suspend fun getDogs(): List<DogModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllDogs()
            val body = response.body()
            body ?: emptyList()
        }
    }
}
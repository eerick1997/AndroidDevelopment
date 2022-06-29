package com.eerick.doggosmvvm.domain.data.network

import com.eerick.doggosmvvm.domain.data.model.DogModel
import retrofit2.Response
import retrofit2.http.GET

interface DogApiClient {
    @GET("api/945366962796773376/")
    suspend fun getAllDogs() : Response<List<DogModel>>
}
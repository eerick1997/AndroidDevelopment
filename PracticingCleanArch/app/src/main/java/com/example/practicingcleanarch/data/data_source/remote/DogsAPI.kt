package com.example.practicingcleanarch.data.data_source.remote

import com.example.practicingcleanarch.data.data_source.remote.responses.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogsAPI {
    @GET("api/breed/labrador/images")
    suspend fun getDogs() : Response<DogResponse>
}
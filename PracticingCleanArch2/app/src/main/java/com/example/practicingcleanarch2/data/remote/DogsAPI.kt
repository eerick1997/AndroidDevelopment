package com.example.practicingcleanarch2.data.remote

import com.example.practicingcleanarch2.data.remote.requests.DogsRequest
import retrofit2.Response
import retrofit2.http.GET

interface DogsAPI {
    @GET("api/breed/labrador/images")
    suspend fun getAllDogs(): Response<DogsRequest>

}
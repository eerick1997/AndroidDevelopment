package com.example.displayingimages.display_images.data.remote

import com.example.displayingimages.display_images.data.remote.responses.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogsAPI {
    @GET("/breed/hound/images")
    suspend fun getImages(): Response<DogResponse>
}
package com.example.displayingimages.display_images.data.remote.responses

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message")
    val images: List<String>,
    val status: String
)
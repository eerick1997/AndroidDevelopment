package com.eerick.doggosmvvm.domain.data.model

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("dogName") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("age") val age: Int,
    @SerializedName("image") val image: String
)
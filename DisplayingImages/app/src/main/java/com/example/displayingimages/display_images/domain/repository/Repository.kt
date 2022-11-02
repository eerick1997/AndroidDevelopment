package com.example.displayingimages.display_images.domain.repository

import androidx.lifecycle.LiveData

interface Repository {
    fun getImages(): LiveData<List<String>>
}
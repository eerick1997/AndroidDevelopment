package com.example.displayingimages.display_images.data.repository

import androidx.lifecycle.LiveData
import com.example.displayingimages.display_images.data.remote.DogsAPI
import com.example.displayingimages.display_images.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val dogsAPI: DogsAPI
) : Repository {
    override fun getImages(): LiveData<List<String>> {
        //fun (get)
    }
}
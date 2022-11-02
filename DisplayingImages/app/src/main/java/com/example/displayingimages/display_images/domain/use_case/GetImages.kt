package com.example.displayingimages.display_images.domain.use_case

import androidx.lifecycle.LiveData
import com.example.displayingimages.display_images.domain.repository.Repository
import javax.inject.Inject

class GetImages @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): LiveData<List<String>> {
        return repository.getImages().
    }
}
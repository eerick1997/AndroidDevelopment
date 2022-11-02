package com.example.practicingcleanarch.domain.use_case

import com.example.practicingcleanarch.domain.repository.DogRepository
import javax.inject.Inject

class GetDogs @Inject constructor(
    private val dogRepository: DogRepository
) {
    suspend operator fun invoke() : List<String> {
        val list = dogRepository.getAllDogs()
        return if (list.isEmpty()) {
            emptyList()
        } else {
            list
        }
    }
}
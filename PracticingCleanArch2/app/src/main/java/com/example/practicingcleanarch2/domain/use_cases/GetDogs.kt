package com.example.practicingcleanarch2.domain.use_cases

import com.example.practicingcleanarch2.domain.repository.DogsRepository
import javax.inject.Inject

class GetDogs @Inject constructor(
    private val dogsRepository: DogsRepository
){
    suspend operator fun invoke(): List<String> {
        return dogsRepository.getDogsFromApi()
    }
}
package com.example.practicingcleanarch.domain.repository

interface DogRepository {
    suspend fun getAllDogs() : List<String>
}
package com.example.practicingcleanarch2.domain.repository

interface DogsRepository {
    suspend fun getDogsFromApi(): List<String>
}
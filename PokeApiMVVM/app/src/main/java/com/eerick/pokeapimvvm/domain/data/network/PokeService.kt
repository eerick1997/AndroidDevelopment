package com.eerick.pokeapimvvm.domain.data.network

import com.eerick.pokeapimvvm.domain.data.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokeService @Inject constructor(private val apiClient: PokeApiClient) {
    suspend fun getPokemon(endpoint: String): PokemonModel? {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getPokemon(endpoint)
            response.body()
        }
    }
}
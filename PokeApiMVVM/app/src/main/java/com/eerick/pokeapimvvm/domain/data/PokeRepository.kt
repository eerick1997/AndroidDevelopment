package com.eerick.pokeapimvvm.domain.data

import android.util.Log
import com.eerick.pokeapimvvm.domain.data.network.PokeApiClient
import com.eerick.pokeapimvvm.domain.data.network.PokeService
import com.eerick.pokeapimvvm.domain.model.Pokemon
import com.eerick.pokeapimvvm.domain.model.toDomain
import java.lang.Exception
import javax.inject.Inject

class PokeRepository @Inject constructor(
    private val API: PokeService) {
    suspend fun getPokemonFromApi(name: String) : Pokemon {
        val response = API.getPokemon("api/v2/pokemon/$name")
        return response?.toDomain() ?: throw Error("Doesn't exist")
    }
}
package com.eerick.pokeapimvvm.domain.data.network

import com.eerick.pokeapimvvm.domain.data.model.PokemonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokeApiClient {
    @GET
    suspend fun getPokemon(@Url url: String): Response<PokemonModel>
}
package com.eerick.pokedex.pokemon_detail

import androidx.lifecycle.ViewModel
import com.eerick.pokedex.data.remote.responses.Pokemon
import com.eerick.pokedex.repository.PokemonRepository
import com.eerick.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}
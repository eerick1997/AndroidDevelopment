package com.eerick.pokeapimvvm.usecase

import com.eerick.pokeapimvvm.domain.data.PokeRepository
import com.eerick.pokeapimvvm.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokeRepository
) {
    suspend operator fun invoke(name: String) : Pokemon {
        return repository.getPokemonFromApi(name)
    }
}
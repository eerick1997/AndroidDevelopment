package com.eerick.pokeapimvvm.usecase

import com.eerick.pokeapimvvm.domain.data.PokeRepository
import com.eerick.pokeapimvvm.domain.model.Pokemon
import javax.inject.Inject

class GetRandomPokemonUseCase @Inject constructor(
    private val pokeRepository: PokeRepository
) {
    suspend operator fun invoke() : Pokemon {
        val randomVal = (0..898).random()
        return pokeRepository.getPokemonFromApi(randomVal.toString())
    }
}
package com.eerick.pokeapimvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eerick.pokeapimvvm.usecase.GetPokemonUseCase
import com.eerick.pokeapimvvm.domain.model.Pokemon
import com.eerick.pokeapimvvm.usecase.GetRandomPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val getRandomPokemonUseCase: GetRandomPokemonUseCase
) :ViewModel() {
    val pokemonModel = MutableLiveData<Pokemon>()
    val imageIndexModel = MutableLiveData<Int>()

    fun onCreate() {
        viewModelScope.launch {
            pokemonModel.postValue(getRandomPokemonUseCase()!!)
            imageIndexModel.postValue(0)
        }
    }

    fun getPokemonByName(name: String) {
        viewModelScope.launch {
            pokemonModel.postValue(getPokemonUseCase(name)!!)
            imageIndexModel.postValue(0)
        }
    }

    fun getRandomPokemon() {
        viewModelScope.launch {
            pokemonModel.postValue(getRandomPokemonUseCase()!!)
            imageIndexModel.postValue(0)
        }
    }

    fun changeImage() {
        var index = imageIndexModel.value?.plus(1)
        val spritesSize = pokemonModel.value?.sprites?.size ?: 0
        if (spritesSize > 0)
            index = index?.rem((spritesSize))
        else
            index = 0
        imageIndexModel.postValue(index!!)
    }

}
package com.eerick.pokeapimvvm.domain.model

import com.eerick.pokeapimvvm.domain.data.model.PokemonModel

data class Pokemon(
    val name: String,
    val exp: Int,
    val stats: Map<Stat.StatType, Stat>,
    val sprites: List<String>,
    val abilities: List<String>)

fun PokemonModel.toDomain(): Pokemon {
    val pokemonStats = mutableMapOf<Stat.StatType, Stat>()
    val pokemonSprites = mutableListOf<String>()
    val pokemonAbilities = mutableListOf<String>()
    stats.forEach { statModel ->
        pokemonStats[Stat.StatType.toStatType(statModel.stat.name)] = statModel.toDomain()
    }
    sprites.url?.let { url ->
        if (url.isNotEmpty() and !url.contains(".svg")) pokemonSprites.add(url)}

    sprites.other.dreamWorld.url?.let { url ->
        if (url.isNotEmpty() and !url.contains(".svg")) pokemonSprites.add(url)}

    sprites.other.home.url?.let { url ->
        if (url.isNotEmpty() and !url.contains(".svg")) pokemonSprites.add(url)}

    sprites.other.officialArtWork.url?.let { url ->
        if (url.isNotEmpty() and !url.contains(".svg")) pokemonSprites.add(url)}

    abilities.forEach { abilityModel ->
        pokemonAbilities.add(abilityModel.details.name)
    }
    return Pokemon(name, exp, pokemonStats, pokemonSprites, pokemonAbilities)
}

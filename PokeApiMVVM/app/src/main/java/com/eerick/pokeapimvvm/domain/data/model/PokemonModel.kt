package com.eerick.pokeapimvvm.domain.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val exp: Int,
    @SerializedName("stats") val stats: List<StatsModel>,
    @SerializedName("sprites") val sprites: SpritesModel,
    @SerializedName("abilities") val abilities: List<AbilityModel>
)

data class StatsModel(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("stat") val stat: StatModel
)

data class StatModel(
    @SerializedName("name") val name: String,
)

data class SpritesModel(
    @SerializedName("front_default") val url: String?,
    @SerializedName("other") val other: OtherSpritesModel
)

data class OtherSpritesModel(
    @SerializedName("dream_world") val dreamWorld: DreamWorldModel,
    @SerializedName("home") val home: HomeModel,
    @SerializedName("official-artwork") val officialArtWork: OfficialArtWorkModel
)

data class DreamWorldModel(
    @SerializedName("front_default") val url: String?
)

data class HomeModel(
    @SerializedName("front_default") val url: String?
)

data class OfficialArtWorkModel(
    @SerializedName("front_default") val url: String?
)

data class AbilityModel(
    @SerializedName("ability") val details: AbilityDetailsModel
)

data class AbilityDetailsModel(
    @SerializedName("name") val name: String
)
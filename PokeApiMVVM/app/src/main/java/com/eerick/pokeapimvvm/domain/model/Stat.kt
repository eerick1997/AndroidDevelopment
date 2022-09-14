package com.eerick.pokeapimvvm.domain.model

import com.eerick.pokeapimvvm.domain.data.model.StatsModel

data class Stat(
    val value: Int,
    val name: StatType) {

    enum class StatType {
        HP,
        ATTACK,
        DEFENSE,
        SPECIAL_ATTACK,
        SPECIAL_DEFENSE,
        SPEED;

        companion object {
            fun toStatType(name: String): StatType {
                return when (name) {
                    "hp" -> HP
                    "attack" -> ATTACK
                    "defense" -> DEFENSE
                    "special-attack" -> SPECIAL_ATTACK
                    "special-defense" -> SPECIAL_DEFENSE
                    "speed" -> SPEED
                    else -> throw Error("That stat doesn't exist")
                }
            }
        }
    }
}

fun StatsModel.toDomain(): Stat = Stat(baseStat, Stat.StatType.toStatType(stat.name))
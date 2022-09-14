package com.eerick.pokeapimvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.eerick.pokeapimvvm.databinding.PokeActivityBinding
import com.eerick.pokeapimvvm.domain.model.Pokemon
import com.eerick.pokeapimvvm.domain.model.Stat
import com.eerick.pokeapimvvm.ui.recyclerview.abilities.AbilitiesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeActivity : AppCompatActivity() {

    private lateinit var binding: PokeActivityBinding
    private lateinit var abilitiesAdapter: AbilitiesAdapter

    private val pokeViewModel: PokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PokeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        pokeViewModel.onCreate()
        pokeViewModel.pokemonModel.observe(this) { pokemon ->
            binding.TVPokemonName.text = pokemon.name.replaceFirstChar{ letter -> letter.uppercaseChar()}
            binding.TVPokemonHp.text = getHpText(pokemon)
            binding.TVPokemonExperience.text = getExpText(pokemon)
            binding.TVAttackStat.text = getAttackText(pokemon)
            binding.TVSpeedStat.text = getSpeedText(pokemon)
            binding.TVDefenseStat.text = getDefenseText(pokemon)
            binding.TVSpecialAttackStat.text = getSpecialAttackText(pokemon)
            binding.TVSpecialDefenseStat.text = getSpecialDefenseText(pokemon)
            val index = pokeViewModel.imageIndexModel.value ?: 0
            loadSprite(index, pokemon)
            abilitiesAdapter.setAbilities(pokemon.abilities)
        }
        pokeViewModel.imageIndexModel.observe(this) { index ->
            val pokemon = pokeViewModel.pokemonModel.value
            loadSprite(index, pokemon!!)
        }
        binding.FABRandomPokemon.setOnClickListener {
            pokeViewModel.getRandomPokemon()
        }
        binding.IVPokemonImage.setOnClickListener {
            pokeViewModel.changeImage()
        }
    }

    private fun loadSprite(index: Int, pokemon: Pokemon) {
        Glide.with(this)
            .load(pokemon.sprites[index])
            .fitCenter()
            .circleCrop()
            .into(binding.IVPokemonImage)
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        abilitiesAdapter = AbilitiesAdapter(emptyList())
        binding.RVAbilities.adapter = abilitiesAdapter
        binding.RVAbilities.layoutManager = manager
    }

    private fun getHpText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.HP))
            "${pokemon.stats[Stat.StatType.HP]?.value} HP"
        else "N/A"
    }

    private fun getExpText(pokemon: Pokemon): String {
        return pokemon.exp.toString() + " exp"
    }

    private fun getAttackText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.ATTACK))
            "${pokemon.stats[Stat.StatType.ATTACK]?.value}"
        else "N/A"
    }

    private fun getSpeedText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.SPEED))
            "${pokemon.stats[Stat.StatType.SPEED]?.value}"
        else "N/A"
    }

    private fun getDefenseText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.DEFENSE))
            "${pokemon.stats[Stat.StatType.DEFENSE]?.value}"
        else "N/A"
    }

    private fun getSpecialAttackText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.SPECIAL_ATTACK))
            "${pokemon.stats[Stat.StatType.SPECIAL_ATTACK]?.value}"
        else "N/A"
    }

    private fun getSpecialDefenseText(pokemon: Pokemon): String {
        return if (pokemon.stats.contains(Stat.StatType.SPECIAL_DEFENSE))
            "${pokemon.stats[Stat.StatType.SPECIAL_DEFENSE]?.value}"
        else "N/A"
    }
}
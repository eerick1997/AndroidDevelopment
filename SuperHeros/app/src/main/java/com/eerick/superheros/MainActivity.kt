package com.eerick.superheros

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.eerick.superheros.adapter.SuperHeroAdapter
import com.eerick.superheros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        binding.recyclerViewSuperHeroes.layoutManager = manager
        binding.recyclerViewSuperHeroes.adapter =
            SuperHeroAdapter(SuperHeroProvider.superHeroesList) { superHeroModel ->
                onItemSelected(superHeroModel)
            }
    }

    private fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.name, Toast.LENGTH_SHORT).show()
    }
}
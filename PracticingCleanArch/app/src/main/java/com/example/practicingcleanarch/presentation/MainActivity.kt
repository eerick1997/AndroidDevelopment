package com.example.practicingcleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practicingcleanarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val dogAdapter = DogsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()
        subscribeToObservers()
        viewModel.getAllDogs()
    }

    private fun subscribeToObservers() {
        viewModel.dogsList.observe(this) { dogsList ->
            dogAdapter.dogsList = dogsList
        }
    }

    private fun setupRecyclerView() {
        binding.rvRecyclerView.apply {
            adapter = dogAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}
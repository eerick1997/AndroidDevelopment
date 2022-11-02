package com.example.practicingcleanarch2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practicingcleanarch2.databinding.ActivityMainBinding
import com.example.practicingcleanarch2.other.Constants.NUMBER_OF_IMAGES
import com.example.practicingcleanarch2.presentation.adapters.DogsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val dogsAdapter = DogsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()
        subscribeToObservers()
        viewModel.getDogsList()
    }

    private fun subscribeToObservers() {
        viewModel.dogsLiveData.observe(this) { dogsList ->
            dogsAdapter.dogsList = dogsList
        }
    }

    private fun setupRecyclerView() {
        binding.rvDogsImages.apply {
            adapter = dogsAdapter
            layoutManager = GridLayoutManager(this@MainActivity, NUMBER_OF_IMAGES)
        }
    }
}
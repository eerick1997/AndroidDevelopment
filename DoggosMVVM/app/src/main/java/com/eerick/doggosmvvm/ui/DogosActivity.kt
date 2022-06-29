package com.eerick.doggosmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.eerick.doggosmvvm.databinding.DogsMainBinding
import com.eerick.doggosmvvm.ui.adapters.DogsRecyclerViewAdapter
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogosActivity : AppCompatActivity() {

    private lateinit var binding: DogsMainBinding
    private lateinit var adapter: DogsRecyclerViewAdapter
    private val dogosViewModel: DogosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DogsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Fresco.initialize(applicationContext)
        initRecyclerView()
        dogosViewModel.onCreate()
        dogosViewModel.dogosModel.observe(this) { dogsList ->
            adapter.setList(dogsList)
        }
        dogosViewModel.isLoading.observe(this) { isVisible ->
            placeHolderManager(isVisible)
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        adapter = DogsRecyclerViewAdapter(emptyList())
        binding.RVDogs.adapter = adapter
        binding.RVDogs.layoutManager = manager
    }

    private fun placeHolderManager(isVisible: Boolean) {
        binding.dogsPlaceholder.isVisible = isVisible
        if (isVisible) binding.dogsPlaceholder.startShimmer()
        else binding.dogsPlaceholder.stopShimmer()
    }
}
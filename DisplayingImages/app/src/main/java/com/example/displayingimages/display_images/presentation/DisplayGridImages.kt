package com.example.displayingimages.display_images.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.displayingimages.databinding.ActivityGridImagesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayGridImages : AppCompatActivity() {

    lateinit var binding: ActivityGridImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
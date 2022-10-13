package com.example.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOne.setOnClickListener {
            binding.customView.customPaddingUp(30)
        }

        binding.btnTwo.setOnClickListener {
            binding.customView.swapColor()
        }

        binding.btnThree.setOnClickListener {
            binding.customView.customPaddingDown(30)
        }
    }
}
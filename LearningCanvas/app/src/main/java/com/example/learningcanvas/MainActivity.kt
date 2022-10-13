package com.example.learningcanvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningcanvas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val customView = CustomView(this)

        binding.root.addView(customView)
        setContentView(binding.root)
    }

}
package com.eerick.learningmvvm.presentation.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.eerick.learningmvvm.databinding.ActivityMainBinding
import com.eerick.learningmvvm.presentation.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityQuotes : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.onCreate()
        quoteViewModel.quoteModel.observe(this) { (quote, author) ->
            binding.textQuote.text = quote
            binding.textAuthor.text = author
        }
        quoteViewModel.isLoading.observe(this) { isVisible ->
            binding.progressQuote.isVisible = isVisible
        }
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}
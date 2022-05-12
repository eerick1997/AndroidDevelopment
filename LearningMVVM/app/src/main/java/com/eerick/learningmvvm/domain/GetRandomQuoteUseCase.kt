package com.eerick.learningmvvm.domain

import com.eerick.learningmvvm.data.QuoteRepository
import com.eerick.learningmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val index = (quotes.indices).random()
            return quotes[index]
        }
        return null
    }
}
package com.eerick.learningmvvm.domain

import com.eerick.learningmvvm.data.QuoteRepository
import com.eerick.learningmvvm.data.database.entities.toEntity
import com.eerick.learningmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { quote -> quote.toEntity() })
            return quotes
        }
        return repository.getAllQuotesFromDatabase()
    }
}
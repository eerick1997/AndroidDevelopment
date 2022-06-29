package com.eerick.learningmvvm.usecase

import com.eerick.learningmvvm.domain.data.QuoteRepository
import com.eerick.learningmvvm.domain.data.database.entities.toEntity
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
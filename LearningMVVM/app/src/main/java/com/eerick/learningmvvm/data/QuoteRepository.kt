package com.eerick.learningmvvm.data

import com.eerick.learningmvvm.data.database.dao.QuoteDao
import com.eerick.learningmvvm.data.database.entities.QuoteEntity
import com.eerick.learningmvvm.data.network.QuoteService
import com.eerick.learningmvvm.domain.model.Quote
import com.eerick.learningmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val API: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = API.getQuotes()
        return response.map { quoteModel -> quoteModel.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { quoteEntity -> quoteEntity.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAll()
    }
}
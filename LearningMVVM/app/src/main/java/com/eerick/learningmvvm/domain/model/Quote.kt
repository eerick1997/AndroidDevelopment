package com.eerick.learningmvvm.domain.model

import com.eerick.learningmvvm.data.database.entities.QuoteEntity
import com.eerick.learningmvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)

package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import javax.inject.Inject
//caso de uso donde se obtiene una nota al azar
class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){//se inyecta el provider
    //obtengo la nota
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){//si es diferente de nullo o vacio
            val randomNumber = (quotes.indices).random()//obtengo una nota al azar
            return quotes[randomNumber]//la retorno
        }
        return null
    }
}
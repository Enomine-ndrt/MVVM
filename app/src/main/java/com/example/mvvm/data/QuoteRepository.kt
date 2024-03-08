package com.example.mvvm.data

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(  private val api : QuoteService,private val quoteProvider:QuoteProvider){
    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()//traigo del rest api
        quoteProvider.quotes = response//lo guardo en memoria
        return response//retorno la respuesta
    }
}
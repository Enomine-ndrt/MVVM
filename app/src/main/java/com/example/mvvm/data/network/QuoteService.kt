package com.example.mvvm.data.network

import com.example.mvvm.core.RetrofitHelper
import com.example.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient) {//injeccion dagger

    suspend fun getQuotes():List<QuoteModel>{//funcion suspendida
        return withContext(Dispatchers.IO) {//corrutina
            val response = api.getAllQuotes()//traer las notas
            response.body() ?: emptyList()//regresa un cuerpo o una lista vacia
        }
    }
}
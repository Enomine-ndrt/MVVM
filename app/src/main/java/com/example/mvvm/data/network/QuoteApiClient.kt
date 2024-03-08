package com.example.mvvm.data.network
import com.example.mvvm.data.model.QuoteModel
import retrofit2.http.GET
import retrofit2.Response

interface QuoteApiClient {
    @GET("/.json")//subdirectorio de endpoint
    suspend fun getAllQuotes():Response<List<QuoteModel>>//se trae las notas
}
package com.example.mvvm.di

import com.example.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module//Module para inyectar retrofit
@InstallIn(SingletonComponent::class)//nivel de alcanze
object NetworkModule {
    //proveo retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton//se crea un singleton
    @Provides//se provee
    fun provideApiClient(retrofit: Retrofit):QuoteApiClient{//se regresa un quoteApiClient
        return retrofit.create(QuoteApiClient::class.java)
    }

}
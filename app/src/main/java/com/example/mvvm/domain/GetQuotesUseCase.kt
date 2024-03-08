package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.QuoteModel
import javax.inject.Inject

//caso de uso donde se obtienen todas las notas
class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository){//se inyecta el repository
    //con invoke no se necesita declarar la funcion de regreso de datos
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()//obtengo la lista de todas las notas
}
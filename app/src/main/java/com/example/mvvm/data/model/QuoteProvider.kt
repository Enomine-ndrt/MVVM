package com.example.mvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton//se crea singleton de esta clase con hilt
class QuoteProvider @Inject constructor() {//se inyecta
        var quotes:List<QuoteModel> = emptyList()//se rellena la lista vacia
}
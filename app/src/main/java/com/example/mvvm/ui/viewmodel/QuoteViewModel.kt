package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.domain.GetQuotesUseCase
import com.example.mvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel//se declara hitviewmodel para viewmodel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase : GetQuotesUseCase,//se inyecta getQuotesUseCase para usarlo
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase//se inyecta getRandomQuoteUseCase para usarlo
): ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()//se crea un mutable live data para las notas
    val isLoading = MutableLiveData<Boolean>()//se crea un mutable live data para el spinner

    //oncreate se crea para cargar al inicio la lista con el rest api
    fun onCreate() {
        viewModelScope.launch {//se crea una corrutina
            isLoading.postValue(true)//se muestra el spinner
            val result:List<QuoteModel>? = getQuotesUseCase()//se rellena la lista QuoteModel puede ser vacia

            if(!result.isNullOrEmpty()){//si es diferente a null o empty
                quoteModel.postValue(result[0])//se toma el primer valor
                isLoading.postValue(false)//se desactiva el spinner
            }
        }
    }

    //funcion random para el evento onclick de la pantalla
    fun randomQuote(){
        isLoading.postValue(true)//se activa el spinner
        val quote = getRandomQuoteUseCase()//se obtiene una nota random
        if(quote != null){
            quoteModel.postValue(quote)//se carga al modelo
        }
        isLoading.postValue(false)//se desactiva el spinner
    }
}
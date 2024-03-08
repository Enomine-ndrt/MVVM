package com.example.mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint//punto de entrada
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()//se incluye el viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//se asigna la vista con binding
        setContentView(binding.root)
        quoteViewModel.onCreate()//se llama la funcion oncreate al incio de la aplicación para cargar la lista con el restapi

        //se activa el observe en el viewmodel de quoteviewmodel
        quoteViewModel.quoteModel.observe(this, Observer{currentQuote ->
            binding.tvQuote.text = currentQuote.quote //se asigna los valores a la vista
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this,Observer{
            binding.progress.isVisible = it//se asigna el estado del spinner depende de la accion
        })
        //evento onclick de la pantalla
        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}//trae una nota random
    }
}
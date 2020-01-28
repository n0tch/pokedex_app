package com.example.pokedex.di

import com.example.pokedex.viewModel.PokemonViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { PokemonViewModel(get()) }
}
package com.example.pokedex.di

import com.example.pokedex.api.PokemonApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single {
        val retrofit: Retrofit = get()
        retrofit.create(PokemonApi::class.java)
    }
}
package com.example.pokedex.di

import com.example.pokedex.repository.IPokemonRepository
import com.example.pokedex.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PokemonRepository(get(), get()) as IPokemonRepository
    }
}
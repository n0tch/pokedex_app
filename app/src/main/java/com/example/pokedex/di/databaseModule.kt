package com.example.pokedex.di

import androidx.room.Room
import com.example.pokedex.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module{
    single {
        Room
            .databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                "pokemon-database"
            ).build()
    }

    single{
        (get() as AppDatabase).pokemonDao()
    }
}
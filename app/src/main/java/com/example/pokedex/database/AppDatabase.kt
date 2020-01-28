package com.example.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.model.FavoritePokemon

@Database(entities = [FavoritePokemon::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun pokemonDao(): FavoritePokemonDao
}
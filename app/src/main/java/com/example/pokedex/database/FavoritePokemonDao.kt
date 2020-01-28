package com.example.pokedex.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedex.model.FavoritePokemon
import io.reactivex.Single

@Dao
interface FavoritePokemonDao {
    @Insert
    fun saveFavoritePokemon(favoritePokemon: FavoritePokemon): Single<Long>

    @Query("SELECT * FROM favoritePokemon")
    fun loadFavoritePokemons(): Single<List<FavoritePokemon>>
}
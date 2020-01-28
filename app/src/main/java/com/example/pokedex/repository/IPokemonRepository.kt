package com.example.pokedex.repository

import com.example.pokedex.model.FavoritePokemon
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListModel
import io.reactivex.Single
import retrofit2.Response

interface IPokemonRepository {
    fun getPokemonList(offset: Int? = null, limit: Int? = null): Single<Response<PokemonListModel>>
    fun getPokemonById(id: Int): Single<Response<Pokemon>>
    fun saveFavoritePokemon(favoritePokemon: FavoritePokemon): Single<Long>
    fun loadFavoritePokemons(): Single<List<FavoritePokemon>>
}
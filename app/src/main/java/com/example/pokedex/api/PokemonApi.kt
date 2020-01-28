package com.example.pokedex.api

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/{id}/")
    fun getPokemonById(@Path("id") pokemonId: Int): Single<Response<Pokemon>>

    @GET("pokemon/")
    fun getPokemonList(@Query("offset") offset: Int? = DEFAULT_OFFSET, @Query("limit") limit: Int? = DEFAULT_LIMIT): Single<Response<PokemonListModel>>

    companion object{
        const val DEFAULT_OFFSET = 0
        const val DEFAULT_LIMIT = 20
    }
}
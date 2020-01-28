package com.example.pokedex.model

import com.example.pokedex.BuildConfig

data class PokemonListModel(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Pokemon>? = emptyList()
){
    fun getNextUrl(): String{
        return next?.removePrefix(BuildConfig.BASE_API_URL) ?: ""
    }
}
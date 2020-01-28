package com.example.pokedex.repository

import com.example.pokedex.api.PokemonApi
import com.example.pokedex.database.FavoritePokemonDao
import com.example.pokedex.model.FavoritePokemon
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class PokemonRepository(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: FavoritePokemonDao
): IPokemonRepository {
    override fun loadFavoritePokemons(): Single<List<FavoritePokemon>> {
        return pokemonDao.loadFavoritePokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveFavoritePokemon(favoritePokemon: FavoritePokemon): Single<Long> {
        return pokemonDao.saveFavoritePokemon(favoritePokemon)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getPokemonList(offset: Int?, limit: Int?): Single<Response<PokemonListModel>>{
        return pokemonApi.getPokemonList(offset, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    override fun getPokemonById(id: Int): Single<Response<Pokemon>> {
        return pokemonApi.getPokemonById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
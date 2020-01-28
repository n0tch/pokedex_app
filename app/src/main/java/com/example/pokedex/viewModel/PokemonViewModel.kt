package com.example.pokedex.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListModel
import com.example.pokedex.repository.IPokemonRepository
import retrofit2.Response

class PokemonViewModel(private val pokemonRepository: IPokemonRepository): BaseViewModel() {
    val pokemonList by lazy { MutableLiveData<List<Pokemon>>() }
    private var isLoading = false

    var pokemonListIndex: Int = 0

    fun loadPokemonList(){
        if(!isLoading){
            isLoading = true
            pokemonRepository.getPokemonList(offset = pokemonListIndex)
                .subscribe(
                    {handlePokemonResponse(it)}, {doOnError(it)}
                ).let(this::addDisposable)
        }
    }

    private fun handlePokemonResponse(pokemonResponse: Response<PokemonListModel>){
        if(pokemonResponse.isSuccessful){
            val pokemonList = pokemonResponse.body()?.results?.map { it.updateId() }
            this.pokemonList.postValue(pokemonList)
        }else{
            error.postValue("Generic Error...")
        }
        isLoading = false
        updatePage()
    }

    private fun updatePage(){
        pokemonListIndex += 20
    }
}
package com.example.pokedex.view.pokemon

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.view.BaseActivity
import com.example.pokedex.view.pokemon.adapter.PokedexAdapter
import com.example.pokedex.viewModel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class PokemonListActivity: BaseActivity() {
    private val viewModel by viewModel<PokemonViewModel>()
    private lateinit var pokemonAdapter: PokedexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadPokemonList()
    }

    override fun registerAdapters() {
        pokemonAdapter = PokedexAdapter(
            clickListener = { loadPokemonDetail(it) }
        )
        pokedexRecycler.adapter = pokemonAdapter
        pokedexRecycler.layoutManager = GridLayoutManager(this, 2)
    }

    override fun registerObservers() {
        viewModel.pokemonList.observe(this, Observer {
            pokemonAdapter.updatePokemonList(it)
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        pokemonAdapter.lastItemFound.observe(this, Observer {
            viewModel.loadPokemonList()
        })
    }

    private fun loadPokemonDetail(pokemon: Pokemon){
        val bundle = Bundle()
        bundle.putParcelable(PokemonDetailActivity.POKEMON_EXTRA, pokemon)
        PokemonDetailActivity.newIntent(this, bundle)
    }
}
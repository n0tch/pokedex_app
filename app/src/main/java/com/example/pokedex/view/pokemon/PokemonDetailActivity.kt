package com.example.pokedex.view.pokemon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.pokedex.R
import com.example.pokedex.extensions.loadImage
import com.example.pokedex.model.Pokemon
import com.example.pokedex.view.BaseActivity
import com.example.pokedex.view.pokemon.adapter.PokedexSpritesAdapter
import kotlinx.android.synthetic.main.layout_pokemon_detail.*

class PokemonDetailActivity: BaseActivity() {

    val pokemon: Pokemon by lazy {
        intent.getParcelableExtra(POKEMON_EXTRA) as Pokemon
    }
    private lateinit var spriteAdapter: PokedexSpritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_pokemon_detail)

        updatePokemonInfo()
    }

    override fun registerAdapters() {
        spriteAdapter = PokedexSpritesAdapter(
            arrayListOf(
                "http://pokeapi.co/media/sprites/pokemon/back/female/25.png",
                "http://pokeapi.co/media/sprites/pokemon/back/shiny/female/25.png",
                "http://pokeapi.co/media/sprites/pokemon/back/25.png"
            )
        )
        spritesRecycler.adapter = spriteAdapter
    }

    private fun updatePokemonInfo() {
        pokemonDetailName.text = pokemon.name
        pokemonDetailImage.loadImage(pokemon.image)
    }

    companion object{
        fun newIntent(context: Context, extras: Bundle? = null){
            val intent = Intent(context, PokemonDetailActivity::class.java)
            extras?.let {
                intent.putExtras(it)
            }
            context.startActivity(intent)
        }

        const val POKEMON_EXTRA = "POKEMON_EXTRA"
    }
}
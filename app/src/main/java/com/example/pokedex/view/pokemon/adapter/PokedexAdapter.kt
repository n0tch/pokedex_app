package com.example.pokedex.view.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.extensions.loadImage
import com.example.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.layout_pokemon_item.view.*

class PokedexAdapter(
    private val clickListener: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>() {
    private lateinit var context: Context
    private val pokemonList: MutableList<Pokemon> = arrayListOf()

    val lastItemFound by lazy { MutableLiveData<Unit>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.layout_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.pokemonName.text = pokemon.name
        holder.pokemonImage.loadImage(pokemon.image)

        if (position == pokemonList.size - 1) {
            lastItemFound.postValue(Unit)
        }

        holder.pokemonContainer.setOnClickListener {
            clickListener(pokemon)
        }
    }

    fun updatePokemonList(list: List<Pokemon>) {
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val pokemonContainer: View = item.pokemonContainer
        var pokemonName: TextView = item.pokemonName
        val pokemonImage: ImageView = item.pokemonImage
    }
}
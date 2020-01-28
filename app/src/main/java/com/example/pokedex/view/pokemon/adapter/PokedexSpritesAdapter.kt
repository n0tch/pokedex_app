package com.example.pokedex.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.extensions.loadImage
import kotlinx.android.synthetic.main.layout_pokemon_sprite_item.view.*

class PokedexSpritesAdapter(
    private val spriteList: List<String>
): RecyclerView.Adapter<PokedexSpritesAdapter.PokedexSpritesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexSpritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_pokemon_sprite_item, parent, false)
        return PokedexSpritesViewHolder(view)
    }

    override fun getItemCount(): Int = spriteList.size

    override fun onBindViewHolder(holder: PokedexSpritesViewHolder, position: Int) {
        val sprite = spriteList[position]
        holder.pokemonSprite.loadImage(sprite)
    }

    inner class PokedexSpritesViewHolder(item: View): RecyclerView.ViewHolder(item){
        val pokemonSprite: ImageView = item.pokemonSprite
    }
}
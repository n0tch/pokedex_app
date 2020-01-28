package com.example.pokedex.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pokedex.BuildConfig

fun ImageView.loadImage(url: String?){
    Glide.with(context)
        .load(url)
        .into(this)
}

fun ImageView.loadPokemonAsset(pokemonId: Int?){
    Glide.with(context)
        .load(BuildConfig.BASE_IMAGE_API_URL + (pokemonId?.plus(1)).toString() + ".png")
        .into(this)

}

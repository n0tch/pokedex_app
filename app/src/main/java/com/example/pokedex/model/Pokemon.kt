package com.example.pokedex.model

import android.os.Parcelable
import com.example.pokedex.BuildConfig
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    var id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("sprites")
    val sprites: List<String>? = emptyList(),
    var image: String? = null
): Parcelable{
    fun updateImagePath(path: Int?){
        image = BuildConfig.BASE_IMAGE_API_URL + id.toString() + ".png"
    }

    fun updateId(): Pokemon{
        id = url
            ?.removePrefix(BuildConfig.BASE_API_URL + "pokemon/")
            ?.replace("/", "")
            ?.toIntOrNull()

        image = BuildConfig.BASE_IMAGE_API_URL + id.toString() + ".png"
        return this
    }
}
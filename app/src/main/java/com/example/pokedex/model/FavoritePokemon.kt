package com.example.pokedex.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritePokemon(
    @PrimaryKey(autoGenerate = true)
    val uuid: Int? = null,
    @ColumnInfo(name = "number")
    val number: Int? = null,
    @ColumnInfo(name = "name")
    val name: String? = null
)
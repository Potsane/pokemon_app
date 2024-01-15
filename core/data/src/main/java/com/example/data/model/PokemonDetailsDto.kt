package com.example.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDto(
    var id: String,
    var name: String,
    var height: Int,
    var weight: Int,
    var stats: List<Stat>,
    var types: List<Type>
)

data class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    var stat: BasePropertyInfo
)

data class Type(
    var slot: Int,
    var type: BasePropertyInfo
)

data class BasePropertyInfo(
    var name: String,
    var url: String
)
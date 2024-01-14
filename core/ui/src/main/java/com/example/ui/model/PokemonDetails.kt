package com.example.ui.model

data class PokemonDetails(
    val id: String = "",
    val name: String = "",
    val avatarUrl: String = "",
    var height: Int = 0,
    var weight: Int = 0,
    var stats: List<PropertyInfo> = emptyList(),
    var types: List<PropertyInfo> = emptyList()
)

data class PropertyInfo(
    var name: String,
    var url: String
)
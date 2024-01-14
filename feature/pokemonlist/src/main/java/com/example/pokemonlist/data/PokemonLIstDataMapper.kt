package com.example.pokemonlist.data

import com.example.data.model.PokemonListDto
import com.example.ui.model.Pokemon

fun List<PokemonListDto>?.toPokemonList(): List<Pokemon> {
    val pokemonList = mutableListOf<Pokemon>()
    this?.forEach {
        val id = it.extractId()
        pokemonList.add(Pokemon(id, it.name, getAvatarUrl(id)))
    }
    return pokemonList
}

private fun PokemonListDto.extractId(): String {
    val pattern = """/(\d+)/?$""".toRegex()
    val match = pattern.find(url)
    val pokemonNumber = match?.value?.substringBeforeLast("/") ?: "0"
    return pokemonNumber.replace("/", "")
}

private fun getAvatarUrl(id: String): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
}
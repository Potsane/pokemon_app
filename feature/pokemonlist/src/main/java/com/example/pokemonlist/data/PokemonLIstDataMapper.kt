package com.example.pokemonlist.data

import com.example.data.model.PokemonListDto
import com.example.pokemonlist.model.Pokemon

fun List<PokemonListDto>?.toPokemonList(): List<Pokemon> {
    val pokemonList = mutableListOf<Pokemon>()
    this?.forEach { pokemonList.add(Pokemon(it.name, it.url)) }
    return pokemonList
}
package com.example.pokemonlist.domain

import com.example.ui.model.Pokemon

interface PokemonListRepository {
    suspend fun getPokemonList() : List<Pokemon>?
}
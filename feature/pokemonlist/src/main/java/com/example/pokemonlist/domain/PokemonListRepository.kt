package com.example.pokemonlist.domain

import com.example.pokemonlist.model.Pokemon

interface PokemonListRepository {
    suspend fun getPokemonList() : List<Pokemon>
}
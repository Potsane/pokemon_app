package com.example.pokemondetail.domain

import com.example.ui.model.PokemonDetails

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(id: String): PokemonDetails?
}
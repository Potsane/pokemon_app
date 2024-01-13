package com.example.data.dataaccessor

import com.example.data.model.PokemonDetailsDto
import com.example.data.model.PokemonListDto
import com.example.data.service.PokemonService
import javax.inject.Inject

interface PokemonDataAccessor {
    suspend fun getPokemonList(): List<PokemonListDto>?
    suspend fun getPokemonDetails(id: String): PokemonDetailsDto?
}

class PokemonDataAccessorImpl @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonDataAccessor {
    override suspend fun getPokemonList(): List<PokemonListDto>? {
        return pokemonService.getPokemonList().body()
    }

    override suspend fun getPokemonDetails(id: String): PokemonDetailsDto? {
        return pokemonService.getPokemonDetails(id).body()
    }
}
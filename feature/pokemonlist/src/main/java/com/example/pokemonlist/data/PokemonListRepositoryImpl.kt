package com.example.pokemonlist.data

import com.example.data.dataaccessor.PokemonDataAccessor
import com.example.pokemonlist.domain.PokemonListRepository
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokemonDataAccessor: PokemonDataAccessor
) : PokemonListRepository {
    override suspend fun getPokemonList() = try {
        pokemonDataAccessor.getPokemonList().toPokemonList()
    } catch (e: Exception) {
        null
    }
}
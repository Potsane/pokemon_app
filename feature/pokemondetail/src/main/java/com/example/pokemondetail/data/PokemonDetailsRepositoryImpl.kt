package com.example.pokemondetail.data

import com.example.data.dataaccessor.PokemonDataAccessor
import com.example.pokemondetail.domain.PokemonDetailsRepository
import com.example.ui.model.PokemonDetails
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val pokemonDataAccessor: PokemonDataAccessor
) : PokemonDetailsRepository {
    override suspend fun getPokemonDetails(id : String): PokemonDetails? {
        return try {
            pokemonDataAccessor.getPokemonDetails(id)?.toPokemonDetails()
        }catch (e : Exception){
            null
        }
    }
}
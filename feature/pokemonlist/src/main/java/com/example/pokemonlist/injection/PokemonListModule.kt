package com.example.pokemonlist.injection

import com.example.data.dataaccessor.PokemonDataAccessor
import com.example.pokemonlist.data.PokemonListRepositoryImpl
import com.example.pokemonlist.domain.PokemonListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PokemonListModule {

    @Provides
    fun providePokemonRepository(pokemonDataAccessor: PokemonDataAccessor): PokemonListRepository {
        return PokemonListRepositoryImpl(pokemonDataAccessor)
    }
}
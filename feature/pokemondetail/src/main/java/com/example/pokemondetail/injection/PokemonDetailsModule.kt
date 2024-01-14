package com.example.pokemondetail.injection

import com.example.data.dataaccessor.PokemonDataAccessor
import com.example.pokemondetail.data.PokemonDetailsRepositoryImpl
import com.example.pokemondetail.domain.PokemonDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PokemonDetailsModule {

    @Provides
    fun providePokemonDetailsRepository(pokemonDataAccessor: PokemonDataAccessor): PokemonDetailsRepository {
        return PokemonDetailsRepositoryImpl(pokemonDataAccessor)
    }
}
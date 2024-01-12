package com.example.data.dataaccessor

interface DataAccessor {

    suspend fun getPokemonList()
    suspend fun getPokemonDetails(id: String)
}

class DataAccessorImpl : DataAccessor {
    override suspend fun getPokemonList() {
    }

    override suspend fun getPokemonDetails(id: String) {
    }
}
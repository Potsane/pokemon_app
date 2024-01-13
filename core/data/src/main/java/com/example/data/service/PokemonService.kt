package com.example.data.service

import com.example.data.model.PokemonDetailsDto
import com.example.data.model.PokemonListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/?offset=0&limit=1010")
    suspend fun getPokemonList(): Response<List<PokemonListDto>>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: String): Response<PokemonDetailsDto>
}
package com.example.pokemonlist.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ui.pokemonlist.PokemonListView

@Composable
fun PokemonListScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel(),
) {
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val searchQuery = pokemonListViewModel.searchQuery.collectAsState()
    PokemonListView(
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
        pokemonList = pokemonList.value
    ) { pokemon ->
        navHostController.navigate("pokemon_details/${pokemon.id}/${pokemon.backgroundColor}")
    }
}
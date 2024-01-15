package com.example.pokemonlist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ui.baseevents.UiEvents
import com.example.ui.pokemonlist.PokemonListView
import com.example.ui.progressindicator.ProgressIndicator

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PokemonListScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel(),
) {
    val uiState = pokemonListViewModel.uiState.value
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val searchQuery = pokemonListViewModel.searchQuery.collectAsState()

    if (uiState is UiEvents.Loading) ProgressIndicator()
    if (uiState is UiEvents.Error) {
        /** show error**/
    }

    PokemonListView(
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
        pokemonList = pokemonList.value
    ) { pokemon ->
        navHostController.navigate("pokemon_details/${pokemon.id}/${pokemon.backgroundColor}")
    }
}
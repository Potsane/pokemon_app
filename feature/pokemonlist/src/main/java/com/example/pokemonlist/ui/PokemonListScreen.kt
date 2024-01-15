package com.example.pokemonlist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ui.pokemonlist.PokemonListView
import com.example.ui.topbar.Screen

@Composable
fun PokemonListScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    pokemonListViewModel: PokemonListViewModel = viewModel()
) {
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val searchQuery = pokemonListViewModel.searchQuery.collectAsState()
    PokemonListView(
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
        pokemonList = pokemonList.value
    ) {
        navHostController.navigate(Screen.PokemonDetails.route)
    }
}
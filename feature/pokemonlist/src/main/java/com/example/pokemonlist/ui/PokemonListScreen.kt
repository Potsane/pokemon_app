package com.example.pokemonlist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.pokemonlist.PokemonListView
import com.example.ui.topbar.PokemonListScreenTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemonListViewModel: PokemonListViewModel = viewModel()
) {

    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val searchQuery = pokemonListViewModel.searchQuery.collectAsState()

    Scaffold(
        modifier = modifier.background(Color.Gray),
       /* topBar = {
            PokemonListScreenTopBar(
                searchQuery.value
            ) { pokemonListViewModel.updateQuery(it) }
        }*/
    ) {
        PokemonListView(pokemonList.value)
    }
}
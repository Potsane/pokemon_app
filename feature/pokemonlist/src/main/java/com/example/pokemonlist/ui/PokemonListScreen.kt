package com.example.pokemonlist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ui.baseevents.UiEvents
import com.example.ui.pokemonlist.PokemonListView
import com.example.ui.progressindicator.ProgressIndicator
import com.example.ui.topbar.Screen
import com.example.ui.topbar.Screen.PokemonDetails.onSearch
import com.example.ui.topbar.SearchBar

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PokemonListScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel(),
) {
    val uiState = pokemonListViewModel.uiState.value
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()

    if (uiState is UiEvents.Loading) ProgressIndicator()
    if (uiState is UiEvents.Error) {
        navHostController.navigate(Screen.PokemonError.route)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
        ) {
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 8.dp,
                    start = 8.dp
                ),
                style = MaterialTheme.typography.titleLarge,
                text = "Pokemons"
            )
            SearchBar(
                modifier = Modifier.padding(8.dp)
            ) { pokemonListViewModel.updateQuery(it) }

        }

        PokemonListView(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding()
            ).fillMaxHeight(),
            pokemonList = pokemonList.value
        ) { pokemon ->
            onSearch = {
                pokemonListViewModel.updateQuery(query = it)
            }
            navHostController.navigate("pokemon_details/${pokemon.id}/${pokemon.backgroundColor}")
        }
    }
}
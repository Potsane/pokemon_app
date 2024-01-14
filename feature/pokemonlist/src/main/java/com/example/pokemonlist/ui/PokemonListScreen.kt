package com.example.pokemonlist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
       topBar = {
            PokemonListScreenTopBar(
                searchQuery.value
            ) { pokemonListViewModel.updateQuery(it) }
        }
    ) {
        PokemonListView(pokemonList.value)
    }
}
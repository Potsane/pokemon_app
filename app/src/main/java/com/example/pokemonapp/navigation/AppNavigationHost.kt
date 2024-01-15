package com.example.pokemonapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokemondetail.ui.PokemonDetailsScreen
import com.example.pokemondetail.ui.PokemonDetailsViewModel
import com.example.pokemonlist.ui.PokemonListScreen
import com.example.pokemonlist.ui.PokemonListViewModel
import com.example.ui.topbar.AppTopBarState
import com.example.ui.topbar.Screen

@Composable
fun AppNavigationHost(
    paddingValues: PaddingValues,
    navController: NavHostController,
    appBarState: AppTopBarState
) {
    val pokemonListViewModel = hiltViewModel<PokemonListViewModel>()
    val pokemonDetailViewModel = hiltViewModel<PokemonDetailsViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) {
            PokemonListScreen(
                navHostController = navController,
                paddingValues = paddingValues,
                pokemonListViewModel = pokemonListViewModel
            )
        }
        composable(Screen.PokemonDetails.route) {
            PokemonDetailsScreen(
                navHostController = navController,
                pokemonDetailViewModel = pokemonDetailViewModel
            )
        }
    }
}
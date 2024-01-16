package com.example.pokemonapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mylibrary.ui.ErrorScreen
import com.example.pokemondetail.ui.PokemonDetailsScreen
import com.example.pokemonlist.ui.PokemonListScreen
import com.example.ui.topbar.Screen

@Composable
fun AppNavigationHost(
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) {
            PokemonListScreen(
                navHostController = navController,
                paddingValues = paddingValues,
            )
        }
        composable(Screen.PokemonError.route) {
            ErrorScreen(
                navHostController = navController
            )
        }
        composable(
            Screen.PokemonDetails.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("color") { type = NavType.IntType }
            )
        ) {
            val id = it.arguments?.getString("id")
            val backgroundColor = it.arguments?.getInt("color")
            PokemonDetailsScreen(
                navHostController = navController,
                id = id,
                color = backgroundColor
            )
        }
    }
}
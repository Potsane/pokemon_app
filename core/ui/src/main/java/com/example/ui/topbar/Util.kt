package com.example.ui.topbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope

fun getScreen(route: String?): Screen? = when (route) {
    Screen.PokemonList.route -> Screen.PokemonList
    Screen.PokemonDetails.route -> Screen.PokemonDetails
    else -> null
}

@Composable
fun rememberAppBarState(
    navController: NavHostController,
    scope: CoroutineScope = rememberCoroutineScope()
) = remember { AppTopBarState(navController, scope) }
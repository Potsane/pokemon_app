package com.example.pokemonapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(navHostController: NavHostController) {
    Scaffold {
        AppNavigationHost(
            paddingValues = it,
            navController = navHostController
        )
    }
}
package com.example.pokemonapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.ui.topbar.AppTopBar
import com.example.ui.topbar.AppTopBarState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(
    navHostController: NavHostController,
    appBarState: AppTopBarState
) {
    Scaffold(
        topBar = { AppTopBar(appBarState) }
    ) {
        AppNavigationHost(
            paddingValues = it,
            navController = navHostController,
            appBarState = appBarState,
        )
    }
}
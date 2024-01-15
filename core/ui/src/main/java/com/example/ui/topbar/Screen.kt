package com.example.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {

    open val navigationIcon: ImageVector = Icons.Default.ArrowBack
    open val showLeadingIcon: Boolean = false
    open var onIconClick: () -> Unit = {}
    open var title: String = ""
    open var backgroundColor: Color = Color(-4147000)
    open var onSearch: (query: String) -> Unit = {}
    open val showSearchBar: Boolean = true

    data object PokemonList : Screen("pokemon_list") {
        override var title: String = "Pokemons"
    }

    data object PokemonDetails : Screen("pokemon_details/{id}/{color}") {
        override val showLeadingIcon = true
        override val showSearchBar = false
    }
}
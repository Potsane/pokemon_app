package com.example.ui.topbar

sealed class Screen(val route: String) {
    open var title: String = ""
    open val showSearchBar: Boolean = true
    open var onSearch: (query: String) -> Unit = {}

    data object PokemonList : Screen("pokemon_list") {
        override var title: String = "Pokemons"
    }

    data object PokemonDetails : Screen("pokemon_details/{id}/{color}") {
        override val showSearchBar = false
    }

    data object PokemonError : Screen("pokemon_error") {
        override val showSearchBar = false
    }
}
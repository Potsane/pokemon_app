package com.example.pokemonlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonlist.domain.PokemonListRepository
import com.example.ui.baseevents.UiEvents
import com.example.ui.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : ViewModel() {

    private val _pokemonList = MutableStateFlow(listOf<Pokemon>())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _uiState: MutableStateFlow<UiEvents> = MutableStateFlow(UiEvents.Loading)
    val uiState: StateFlow<Any> = _uiState

    init {
        fetchPokemonList()
    }

    fun updateQuery(query: String) = _searchQuery.apply { value = query }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            pokemonListRepository.getPokemonList()?.let {
                _pokemonList.value = it
                _uiState.value = UiEvents.Success
            } ?: run {
                _uiState.value = UiEvents.Error
            }
        }
    }
}

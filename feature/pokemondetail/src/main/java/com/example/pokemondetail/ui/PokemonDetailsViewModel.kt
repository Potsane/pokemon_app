package com.example.pokemondetail.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemondetail.domain.PokemonDetailsRepository
import com.example.ui.baseevents.UiEvents
import com.example.ui.model.PokemonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) : ViewModel() {

    private val _pokemonDetails = mutableStateOf(PokemonDetails())
    val pokemonDetails: State<PokemonDetails?> = _pokemonDetails

    private val _uiState: MutableStateFlow<UiEvents> = MutableStateFlow(UiEvents.Loading)
    val uiState: StateFlow<Any> = _uiState

    fun fetchPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            pokemonDetailsRepository.getPokemonDetails(pokemonId)?.let {
                _pokemonDetails.value = it
                _uiState.value = UiEvents.Success
            } ?: run { _uiState.value = UiEvents.Error }
        }
    }
}

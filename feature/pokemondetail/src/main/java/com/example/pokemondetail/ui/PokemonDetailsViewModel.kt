package com.example.pokemondetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemondetail.domain.PokemonDetailsRepository
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

    private val _pokemonDetails = MutableStateFlow<PokemonDetails?>(PokemonDetails())
    val pokemonDetails: StateFlow<PokemonDetails?> = _pokemonDetails

    init {
        fetchPokemonDetails("1")
    }

    fun fetchPokemonDetails(id: String) {
        viewModelScope.launch {
            _pokemonDetails.value = pokemonDetailsRepository.getPokemonDetails(id)
        }
    }
}

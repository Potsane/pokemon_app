package com.example.pokemondetail.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemondetail.domain.PokemonDetailsRepository
import com.example.ui.model.PokemonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) : ViewModel() {

    private val _pokemonDetails = mutableStateOf(PokemonDetails())
    val pokemonDetails: State<PokemonDetails?> = _pokemonDetails

    fun fetchPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            pokemonDetailsRepository.getPokemonDetails(pokemonId)?.let {
                _pokemonDetails.value = it
            }
        }
    }
}

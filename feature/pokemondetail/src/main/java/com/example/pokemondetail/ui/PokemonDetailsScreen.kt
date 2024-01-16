package com.example.pokemondetail.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.ui.baseevents.UiEvents
import com.example.ui.pokemondetails.PokemonBaseStats
import com.example.ui.pokemondetails.PokemonTypeSection
import com.example.ui.pokemonlist.LoadingAnimation
import com.example.ui.progressindicator.ProgressIndicator
import com.example.ui.topbar.Screen

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PokemonDetailsScreen(
    navHostController: NavHostController,
    color: Int?,
    id: String?,
    pokemonDetailViewModel: PokemonDetailsViewModel = hiltViewModel(),
) {
    val uiState = pokemonDetailViewModel.uiState.value
    val pokemonDetails = pokemonDetailViewModel.pokemonDetails.value
    val appBarBackground = color?.takeIf { it != 0 }?.let { Color(color = it) } ?: Color.Gray

    id?.let {
        pokemonDetailViewModel.fetchPokemonDetails(it)
    } ?: { navHostController.navigate(Screen.PokemonError.route) }

    if (uiState is UiEvents.Loading) ProgressIndicator()
    if (uiState is UiEvents.Error) navHostController.navigate(Screen.PokemonError.route)

    Column(
        modifier = Modifier
            .background(appBarBackground)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 16.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    navHostController.navigate(Screen.PokemonList.route)
                }
            ) { Icon(Icons.Default.ArrowBack, contentDescription = null) }
        }

        Box(
            modifier = Modifier.padding(top = 54.dp)
        ) {
            val overlayBoxHeight = (-80).dp
            Card(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 32.dp,
                        top = 16.dp
                    )
                    .fillMaxSize(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                pokemonDetails?.let {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 88.dp, start = 16.dp, end = 16.dp
                            )
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(text = "#${it.id}")
                    }

                    PokemonTypeSection(
                        it.types,
                        appBarBackground,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    PokemonBaseStats(
                        pokemonInfo = it,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            SubcomposeAsyncImage(
                model = pokemonDetails?.avatarUrl,
                contentDescription = null,
                modifier = Modifier
                    .align(TopCenter)
                    .offset(x = 0.dp, y = overlayBoxHeight),
                contentScale = ContentScale.Fit,
                loading = { LoadingAnimation() }
            )
        }
    }
}

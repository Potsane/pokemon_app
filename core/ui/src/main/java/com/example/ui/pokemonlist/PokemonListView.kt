package com.example.ui.pokemonlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.ui.model.Pokemon
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.graphics.Color
import coil.compose.SubcomposeAsyncImage

@Composable
fun PokemonListView(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    /*Column(
        modifier = modifier.padding(top = 8.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(pokemonList) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color.Yellow)
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .padding(
                                vertical = 8.dp,
                                horizontal = 16.dp
                            )
                            .fillMaxWidth()
                            .height(130.dp),
                        alignment = Alignment.Center,
                        model = it.avatarUrl, // we ger image here
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        loading = { LoadingAnimation() }
                    )
                }
            }
        }
    }*/
}
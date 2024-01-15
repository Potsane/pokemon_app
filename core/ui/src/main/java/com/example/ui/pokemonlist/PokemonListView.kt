package com.example.ui.pokemonlist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.ui.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PokemonListView(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier,
    onCardClick: (Pokemon) -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(horizontal = 8.dp),
            columns = GridCells.Fixed(2)
        ) {

            itemsIndexed(pokemonList) { index, item ->
                var backgroundColor by remember { mutableStateOf(Color(-4147000)) }
                LaunchedEffect(index) {
                    withContext(Dispatchers.IO) {
                        val loader = ImageLoader(context)
                        val request = ImageRequest.Builder(context)
                            .data(item.avatarUrl)
                            .allowHardware(false)
                            .build()
                        val result = (loader.execute(request) as SuccessResult).drawable
                        val bitmap = (result as BitmapDrawable).bitmap
                        backgroundColor = getDominantColor(bitmap)
                    }
                }

                Card(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clickable { onCardClick(item) },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(backgroundColor)
                    ) {
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp
                                )
                                .fillMaxWidth()
                                .height(120.dp),
                            alignment = Alignment.Center,
                            model = item.avatarUrl,
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            loading = { LoadingAnimation() }
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .fillMaxWidth(),
                            text = item.name,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

fun getDominantColor(bitmap: Bitmap?): Color {
    if (bitmap == null) return Color.Yellow

    val palette = Palette.from(bitmap).generate()
    val paletteValue = palette.lightMutedSwatch?.rgb
    paletteValue?.let { return Color(it) }
    return Color.Yellow
}

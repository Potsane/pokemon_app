package com.example.pokemondetail.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.ui.model.PokemonDetails
import com.example.ui.model.PropertyInfo
import com.example.ui.pokemonlist.LoadingAnimation
import com.example.ui.topbar.Screen

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PokemonDetailsScreen(
    navHostController: NavHostController,
    color: Int?,
    id: String?,
    pokemonDetailViewModel: PokemonDetailsViewModel = hiltViewModel(),
) {
    val pokemonDetails = pokemonDetailViewModel.pokemonDetails.value
    val appBarBackground = color?.takeIf { it != 0 }?.let { Color(color = it) } ?: Color.Gray

    id?.let {
        pokemonDetailViewModel.fetchPokemonDetails(it)
    } ?: { /** show error**/ }

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
            ) { Icon(Icons.Default.Home, contentDescription = null) }

            // Text(text = "This is the current Pokemon")
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
                        Text(text = it.name)
                        Text(text = it.id)
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

@Composable
fun PokemonTypeSection(
    types: List<PropertyInfo>,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                horizontal = 16.dp
            )
    ) {
        for (type in types) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .height(24.dp)

            ) {
                Text(
                    text = type.name,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemonInfo: PokemonDetails,
    modifier: Modifier = Modifier,
    animDelayPerItem: Int = 100
) {
    var maxBaseStat = remember { 100 }

    if (pokemonInfo.stats.isNotEmpty()) {
        pokemonInfo.stats.forEach {
            if (it.key > maxBaseStat) maxBaseStat = it.key
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "base stats:",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(16.dp))

        for (i in pokemonInfo.stats.indices) {
            val stat = pokemonInfo.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.key,
                statMaxValue = maxBaseStat,
                statColor = parseStatToColor(stat),
                animDelay = i * animDelayPerItem
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 24.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF505050)
                } else {
                    Color.LightGray
                }
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = statName,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

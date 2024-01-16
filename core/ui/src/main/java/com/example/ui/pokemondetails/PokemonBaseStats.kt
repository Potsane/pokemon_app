package com.example.ui.pokemondetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.model.PokemonDetails

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
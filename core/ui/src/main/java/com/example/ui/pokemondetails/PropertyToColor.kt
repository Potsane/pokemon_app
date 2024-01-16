package com.example.ui.pokemondetails

import androidx.compose.ui.graphics.Color
import com.example.ui.model.PropertyInfo
import com.example.ui.theme.DefColor
import com.example.ui.theme.SpDefColor
import com.example.ui.theme.SpdColor
import com.example.ui.theme.TypeElectric
import com.example.ui.theme.TypeFire
import com.example.ui.theme.TypeRock

fun parseStatToColor(stat: PropertyInfo): Color {
    return when (stat.name.lowercase()) {
        "hp" -> TypeFire
        "attack" -> TypeElectric
        "defense" -> DefColor
        "special-attack" -> TypeRock
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: PropertyInfo): String {
    return when (stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}
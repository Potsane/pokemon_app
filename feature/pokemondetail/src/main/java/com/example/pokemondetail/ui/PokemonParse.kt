package com.example.pokemondetail.ui

import androidx.compose.ui.graphics.Color
import com.example.data.model.Type
import com.example.ui.model.PropertyInfo
import com.example.ui.theme.AtkColor
import com.example.ui.theme.DefColor
import com.example.ui.theme.HPColor
import com.example.ui.theme.SpAtkColor
import com.example.ui.theme.SpDefColor
import com.example.ui.theme.SpdColor
import com.example.ui.theme.TypeBug
import com.example.ui.theme.TypeDark
import com.example.ui.theme.TypeDragon
import com.example.ui.theme.TypeElectric
import com.example.ui.theme.TypeFairy
import com.example.ui.theme.TypeFighting
import com.example.ui.theme.TypeFire
import com.example.ui.theme.TypeFlying
import com.example.ui.theme.TypeGhost
import com.example.ui.theme.TypeGrass
import com.example.ui.theme.TypeGround
import com.example.ui.theme.TypeIce
import com.example.ui.theme.TypeNormal
import com.example.ui.theme.TypePoison
import com.example.ui.theme.TypePsychic
import com.example.ui.theme.TypeRock
import com.example.ui.theme.TypeSteel
import com.example.ui.theme.TypeWater

fun parseTypeToColor(type: Type): Color {
    return when (type.type.name.lowercase()) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "eletric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: PropertyInfo): Color {
    return when (stat.name.lowercase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
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
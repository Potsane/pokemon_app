package com.example.pokemondetail.data

import com.example.data.model.PokemonDetailsDto
import com.example.data.model.Stat
import com.example.data.model.Type
import com.example.ui.model.PokemonDetails
import com.example.ui.model.PropertyInfo

fun PokemonDetailsDto.toPokemonDetails(): PokemonDetails {
    return PokemonDetails(
        id = id,
        name = name,
        avatarUrl = getAvatarUrl(id),
        height = height,
        weight = weight,
        stats = getStats(stats),
        types = getTypes(types)
    )
}

private fun getAvatarUrl(id: String): String {
    //return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/${id}.png"
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
}

private fun getStats(stats: List<Stat>?): List<PropertyInfo> {
    val uiStats = mutableListOf<PropertyInfo>()
    stats?.forEach {
        uiStats.add(PropertyInfo(key = it.baseStat, name = it.stat.name, url = it.stat.url))
    }
    return uiStats
}

private fun getTypes(types: List<Type>?): List<PropertyInfo> {
    val uiTypes = mutableListOf<PropertyInfo>()
    types?.forEach {
        uiTypes.add(PropertyInfo(name = it.type.name, url = it.type.url))
    }
    return uiTypes
}
package com.diegochancafe.pokedex.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class PokemonModelResponse (
    val abilities: List<PokemonAbility>,
    val id: Int,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<PokemonMove>,
    val name: String,
    val species: PokemonInfo,
    val types: List<PokemonType>,
): Serializable

// --
data class PokemonAbility (
    val ability: PokemonInfo,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
): Serializable

// --
data class PokemonMove (
    val move: PokemonInfo
): Serializable

// --
data class PokemonType (
    val slot: Int,
    val type: PokemonInfo
): Serializable

// --
data class PokemonInfo (
    val name: String,
    val url: String
): Serializable
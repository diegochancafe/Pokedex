package com.diegochancafe.pokedex.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class PokemonModelResponse (

    val abilities: List<PokemonAbility>,
//    @SerializedName("base_experience") val baseExperience: Int,
//    val forms: List<PokemonInfo>,
//    val height: Int,
    val id: Int,
//    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<PokemonMove>,
    val name: String
//    val order: Int,
//    val species: PokemonInfo,
//    val sprites: PokemonSprites,
//    val stats: List<PokemonStat>,
//    val types: List<PokemonType>,
//    val weight: Int
): Serializable

// --
data class PokemonAbility (
    val ability: PokemonInfo,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
): Serializable

// --
data class PokemonSprites (
    @SerializedName("back_default") val backDefault: String,
    @SerializedName("back_female") val backFemale: Any? = null,
    @SerializedName("back_shiny") val backShiny: String,
    @SerializedName("back_shiny_female") val backShinyFemale: Any? = null,
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_female") val frontFemale: Any? = null,
    @SerializedName("front_shiny") val frontShiny: String,
    @SerializedName("front_shiny_female") val frontShinyFemale: Any? = null
)

// --
data class PokemonMove (
    val move: PokemonInfo
//    @SerializedName("version_group_details") val versionGroupDetails: List<PokemonVersionGroupDetail>
): Serializable

// --
data class PokemonVersionGroupDetail (
    @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @SerializedName("move_learn_method") val moveLearnMethod: PokemonInfo,
    @SerializedName("version_group") val versionGroup: PokemonInfo
): Serializable

// --
data class PokemonStat (
    @SerializedName("base_stat") val baseStat: Int,
    val effort: Int,
    val stat: PokemonInfo
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
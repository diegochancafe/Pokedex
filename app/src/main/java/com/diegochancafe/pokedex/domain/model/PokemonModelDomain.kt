package com.diegochancafe.pokedex.domain.model

import com.diegochancafe.pokedex.data.database.entities.PokemonAbilityEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonInfoEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonMoveEntity
import com.diegochancafe.pokedex.data.model.response.PokemonAbility
import com.diegochancafe.pokedex.data.model.response.PokemonInfo
import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import com.diegochancafe.pokedex.data.model.response.PokemonMove
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class PokemonModelDomain (
    val abilities: List<PokemonAbilityDomain>,
//    @SerializedName("base_experience") val baseExperience: Int,
//    val forms: List<PokemonInfo>,
//    val height: Int,
    val id: Int,
//    @SerializedName("is_default") val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<PokemonMoveDomain>,
    val name: String
//    val order: Int,
//    val species: PokemonInfo,
//    val sprites: PokemonSprites,
//    val stats: List<PokemonStat>,
//    val types: List<PokemonType>,
//    val weight: Int
): Serializable

// --
data class PokemonAbilityDomain (
    val ability: PokemonInfoDomain,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
): Serializable

// --
data class PokemonSpritesDomain (
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
data class PokemonMoveDomain (
    val move: PokemonInfoDomain
//    @SerializedName("version_group_details") val versionGroupDetails: List<PokemonVersionGroupDetail>
): Serializable
//
//// --
//data class PokemonVersionGroupDetail (
//    @SerializedName("level_learned_at") val levelLearnedAt: Int,
//    @SerializedName("move_learn_method") val moveLearnMethod: PokemonInfo,
//    @SerializedName("version_group") val versionGroup: PokemonInfo
//): Serializable
//
//// --
//data class PokemonStat (
//    @SerializedName("base_stat") val baseStat: Int,
//    val effort: Int,
//    val stat: PokemonInfo
//): Serializable
//
//// --
//data class PokemonType (
//    val slot: Long,
//    val type: PokemonInfo
//): Serializable

// --
data class PokemonInfoDomain (
    val name: String,
    val url: String
): Serializable


// --
fun PokemonMove.toDomain() = PokemonMoveDomain(move.toDomain())
fun PokemonMoveEntity.toDomain() = PokemonMoveDomain(move.toDomain())
// --
fun PokemonInfo.toDomain() = PokemonInfoDomain(name, url)
fun PokemonInfoEntity.toDomain() = PokemonInfoDomain(name, url)
// --
fun PokemonAbility.toDomain() = PokemonAbilityDomain(ability.toDomain(), isHidden, slot)
fun PokemonAbilityEntity.toDomain() = PokemonAbilityDomain(ability.toDomain(), isHidden, slot)
// --
fun PokemonModelResponse.toDomain() = PokemonModelDomain(abilities.map { it.toDomain() }, id, locationAreaEncounters, moves.map { it.toDomain() }, name)
fun PokemonEntity.toDomain() = PokemonModelDomain(abilities.map { it.toDomain() }, id, locationAreaEncounters, moves.map { it.toDomain() }, name)

package com.diegochancafe.pokedex.domain.model

import com.diegochancafe.pokedex.data.database.entities.*
import com.diegochancafe.pokedex.data.model.response.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class PokemonModelDomain (
    val abilities: List<PokemonAbilityDomain>,
    val id: Int,
    val locationAreaEncounters: String,
    val moves: List<PokemonMoveDomain>,
    val name: String,
    val species: PokemonInfoDomain,
    val types: List<PokemonTypeDomain>
): Serializable

// --
data class PokemonAbilityDomain (
    val ability: PokemonInfoDomain,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
): Serializable

// --
data class PokemonMoveDomain (
    val move: PokemonInfoDomain
): Serializable

// --
data class PokemonTypeDomain (
    val slot: Int,
    val type: PokemonInfoDomain
): Serializable

// --
data class PokemonInfoDomain (
    val name: String?,
    val url: String
): Serializable



// -- Extensions
fun PokemonMove.toDomain() = PokemonMoveDomain(move.toDomain())
fun PokemonMoveEntity.toDomain() = PokemonMoveDomain(move.toDomain())
// --
fun PokemonInfo.toDomain() = PokemonInfoDomain(name, url)
fun PokemonInfoEntity.toDomain() = PokemonInfoDomain(name, url)
// --
fun PokemonType.toDomain() = PokemonTypeDomain(slot, type.toDomain())
fun PokemonTypeEntity.toDomain() = PokemonTypeDomain(slot, type.toDomain())
// --
fun PokemonAbility.toDomain() = PokemonAbilityDomain(ability.toDomain(), isHidden, slot)
fun PokemonAbilityEntity.toDomain() = PokemonAbilityDomain(ability.toDomain(), isHidden, slot)
// --
fun PokemonModelResponse.toDomain() = PokemonModelDomain(abilities.map { it.toDomain() }, id, locationAreaEncounters, moves.map { it.toDomain() }, name, species.toDomain(), types.map { it.toDomain() })
fun PokemonEntity.toDomain() = PokemonModelDomain(abilities.map { it.toDomain() }, id, locationAreaEncounters, moves.map { it.toDomain() }, name, species.toDomain(), types.map { it.toDomain() })

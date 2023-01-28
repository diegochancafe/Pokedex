package com.diegochancafe.pokedex.data.database.entities

import androidx.room.*
import com.diegochancafe.pokedex.data.database.Converters
import com.diegochancafe.pokedex.data.model.response.*
import com.diegochancafe.pokedex.domain.model.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
@Entity(tableName = "pokemon_table")
data class PokemonEntity (
    // --
    @TypeConverters(Converters::class)
    @SerializedName("abilities") val abilities: List<PokemonAbilityEntity>,
    // --
    @PrimaryKey
    @ColumnInfo("id") val id: Int,
    // --
    @ColumnInfo("location_area_encounters") val locationAreaEncounters: String,
    // --
    @TypeConverters(Converters::class)
    @ColumnInfo("moves") val moves: List<PokemonMoveEntity>,
    // --
    @ColumnInfo("name") val name: String,
    // --
    @TypeConverters(Converters::class)
    @ColumnInfo("species") val species: PokemonInfoEntity,
    // --
    @TypeConverters(Converters::class)
    @ColumnInfo("types") val types: List<PokemonTypeEntity>
)

data class PokemonAbilityEntity (
    @ColumnInfo("ability") val ability: PokemonInfoEntity,
    @ColumnInfo("is_hidden") val isHidden: Boolean,
    @ColumnInfo("slot")  val slot: Int
)

// --
data class PokemonInfoEntity (
    @ColumnInfo("name") val name: String?,
    @ColumnInfo("url") val url: String
)

data class PokemonTypeEntity(
    @ColumnInfo("slot") val slot: Int,
    @ColumnInfo("type") val type: PokemonInfoEntity
)

data class PokemonMoveEntity (
    @ColumnInfo("move") val move: PokemonInfoEntity
)

// -- Extensions
fun PokemonMoveDomain.toDatabase() = PokemonMoveEntity(move.toDatabase())
fun PokemonInfoDomain.toDatabase() = PokemonInfoEntity(name, url)
fun PokemonTypeDomain.toDatabase() = PokemonTypeEntity(slot, type.toDatabase())
fun PokemonAbilityDomain.toDatabase() = PokemonAbilityEntity(ability.toDatabase(), isHidden, slot)
fun PokemonModelDomain.toDatabase() = PokemonEntity(abilities.map { it.toDatabase() }, id, locationAreaEncounters, moves.map { it.toDatabase() }, name, species.toDatabase(), types.map { it.toDatabase() })
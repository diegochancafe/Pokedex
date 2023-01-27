package com.diegochancafe.pokedex.data.database.entities

import androidx.room.*
import com.diegochancafe.pokedex.data.database.Converters
import com.diegochancafe.pokedex.data.model.response.*
import com.diegochancafe.pokedex.domain.model.*
import com.google.gson.annotations.SerializedName

// --
@Entity(tableName = "pokemon_table")
data class PokemonEntity (
    // --
    @TypeConverters(Converters::class)
    @SerializedName("abilities")
    val abilities: List<PokemonAbilityEntity>,
//    @ColumnInfo("base_experience") val baseExperience: Int,
//    @ColumnInfo("forms") val forms: List<PokemonInfo>,
//    @ColumnInfo("height") val height: Int,

    @PrimaryKey @ColumnInfo("id") val id: Int,
//    @ColumnInfo("is_default") val isDefault: Boolean,
    @ColumnInfo("location_area_encounters") val locationAreaEncounters: String,
    @TypeConverters(Converters::class)
    @ColumnInfo("moves") val moves: List<PokemonMoveEntity>,
    @ColumnInfo("name") val name: String
//    @ColumnInfo("order") val order: Int,
//    @ColumnInfo("species") val species: PokemonInfo,
//    @ColumnInfo("sprites") val sprites: PokemonSprites,
//    @ColumnInfo("stats") val stats: List<PokemonStat>,
//    @ColumnInfo("types") val types: List<PokemonType>,
//    @ColumnInfo("weight") val weight: Int
)

data class PokemonAbilityEntity (
    @ColumnInfo("ability") val ability: PokemonInfoEntity,
    @ColumnInfo("is_hidden") val isHidden: Boolean,
    @ColumnInfo("slot")  val slot: Int
)

// --
data class PokemonInfoEntity (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)


data class PokemonMoveEntity (
    @ColumnInfo("move") val move: PokemonInfoEntity
)


fun PokemonMoveDomain.toDatabase() = PokemonMoveEntity(move.toDatabase())
fun PokemonInfoDomain.toDatabase() = PokemonInfoEntity(name, url)
fun PokemonAbilityDomain.toDatabase() = PokemonAbilityEntity(ability.toDatabase(), isHidden, slot)
fun PokemonModelDomain.toDatabase() = PokemonEntity(abilities.map { it.toDatabase() }, id, locationAreaEncounters, moves.map { it.toDatabase() }, name)
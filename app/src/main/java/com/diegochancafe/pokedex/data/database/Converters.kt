package com.diegochancafe.pokedex.data.database

import androidx.room.TypeConverter
import com.diegochancafe.pokedex.data.database.entities.PokemonAbilityEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonInfoEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonMoveEntity
import com.diegochancafe.pokedex.data.database.entities.PokemonTypeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Converters {
    @TypeConverter
    fun listToJsonPokemonAbility(types: List<PokemonAbilityEntity?>?): String {
        return Gson().toJson(types)
    }

    @TypeConverter
    fun jsonToListPokemonAbility(types: String?): List<PokemonAbilityEntity> {
        return Gson().fromJson<List<PokemonAbilityEntity>>(
            types,
            object : TypeToken<ArrayList<PokemonAbilityEntity?>?>() {}.type
        )
    }

    @TypeConverter
    fun listToJsonPokemonMove(types: List<PokemonMoveEntity?>?): String {
        return Gson().toJson(types)
    }

    @TypeConverter
    fun jsonToListPokemonMove(types: String?): List<PokemonMoveEntity> {
        return Gson().fromJson<List<PokemonMoveEntity>>(
            types,
            object : TypeToken<ArrayList<PokemonMoveEntity?>?>() {}.type
        )
    }


    @TypeConverter
    fun listToJsonPokemonType(types: List<PokemonTypeEntity?>?): String {
        return Gson().toJson(types)
    }

    @TypeConverter
    fun jsonToListPokemonType(types: String?): List<PokemonTypeEntity> {
        return Gson().fromJson<List<PokemonTypeEntity>>(
            types,
            object : TypeToken<ArrayList<PokemonTypeEntity?>?>() {}.type
        )
    }


    @TypeConverter
    fun listToJsonPokemonSpecie(types: PokemonInfoEntity?): String {
        return Gson().toJson(types)
    }

    @TypeConverter
    fun jsonToListPokemonSpecie(types: String?): PokemonInfoEntity {
        return Gson().fromJson<PokemonInfoEntity>(
            types,
            object : TypeToken<PokemonInfoEntity?>() {}.type
        )
    }
}
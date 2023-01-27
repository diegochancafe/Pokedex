package com.diegochancafe.pokedex.data.database.entities

import androidx.room.TypeConverter
import com.diegochancafe.pokedex.data.model.response.PokemonAbility
import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import com.diegochancafe.pokedex.domain.model.PokemonAbilityDomain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Converters {
    @TypeConverter
    fun listToJson(types: List<PokemonAbilityEntity?>?): String {
        return Gson().toJson(types)
    }

    @TypeConverter
    fun jsonToList(types: String?): List<PokemonAbilityEntity> {
        return Gson().fromJson<List<PokemonAbilityEntity>>(
            types,
            object : TypeToken<ArrayList<PokemonAbilityEntity?>?>() {}.type
        )
    }
}
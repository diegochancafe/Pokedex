package com.diegochancafe.pokedex.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegochancafe.pokedex.data.database.entities.PokemonEntity

@Dao
interface IPokemonDao {
    // --
    @Query("SELECT * FROM pokemon_table")
    suspend fun getAll(): List<PokemonEntity>

    // --
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonEntity>)

    // --
    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAll()
}
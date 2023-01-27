package com.diegochancafe.pokedex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegochancafe.pokedex.data.database.dao.IPokemonDao
import com.diegochancafe.pokedex.data.database.entities.Converters
import com.diegochancafe.pokedex.data.database.entities.PokemonEntity

@Database(entities = [
    PokemonEntity::class
], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    // --
    abstract fun getPokemonDao(): IPokemonDao
}
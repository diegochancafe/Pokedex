package com.diegochancafe.pokedex.data.repository

import com.diegochancafe.pokedex.data.database.dao.IPokemonDao
import com.diegochancafe.pokedex.data.database.entities.PokemonEntity
import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import com.diegochancafe.pokedex.data.network.service.PokemonService
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.domain.model.toDomain
import com.diegochancafe.pokedex.util.Config
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    // -- Injections
    private val api: PokemonService,
    private val pokemonDao: IPokemonDao
) {
    // --
    suspend fun getPokemonFromApi(): List<PokemonModelDomain> {
        // --
        val data: MutableList<PokemonModelDomain> = mutableListOf()
        // --
        for (i in 1..Config.COUNT_POKEMON) {
            val result = api.getPokemon(i)
            if (result != null) {
                data.add(result.toDomain())
            }
        }
        // ---
        return if (data.isEmpty()) {
            emptyList()
        } else {
            data
        }
    }

    // --
    suspend fun getPokemonFromDatabase(): List<PokemonModelDomain>  {
        // --
        val response: List<PokemonEntity> = pokemonDao.getAll()
        return response.map { it.toDomain() }
    }

    // --
    suspend fun getPokemonByNameFromDatabase(name: String): List<PokemonModelDomain>  {
        // --
        val response: List<PokemonEntity> = pokemonDao.getPokemonByName(name)
        return response.map { it.toDomain() }
    }

    // --
    suspend fun insertPokemonData(pokemonList: List<PokemonEntity>) {
        // --
        pokemonDao.insertAll(pokemonList)
    }

    // --
    suspend fun deleteAll() {
        // --
        pokemonDao.deleteAll()
    }
}

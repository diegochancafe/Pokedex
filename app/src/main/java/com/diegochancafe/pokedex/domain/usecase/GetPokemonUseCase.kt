package com.diegochancafe.pokedex.domain.usecase

import com.diegochancafe.pokedex.data.database.entities.toDatabase
import com.diegochancafe.pokedex.data.repository.PokemonRepository
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokemonRepository) {
    // --
    suspend operator fun invoke(): List<PokemonModelDomain> {
        // --
        val resultDatabase = repository.getPokemonFromDatabase()
        // --
        return resultDatabase.ifEmpty {
            // --
            val resultApi = repository.getPokemonFromApi()
            // --
            repository.deleteAll()
            repository.insertPokemonData(resultApi.map { it.toDatabase() })
            resultApi
        }
    }
}
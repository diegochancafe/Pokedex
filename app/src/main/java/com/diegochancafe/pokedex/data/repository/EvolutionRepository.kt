package com.diegochancafe.pokedex.data.repository

import com.diegochancafe.pokedex.data.database.dao.IPokemonDao
import com.diegochancafe.pokedex.data.network.service.EvolutionService
import com.diegochancafe.pokedex.domain.model.*
import javax.inject.Inject

class EvolutionRepository @Inject constructor(
    // -- Injections
    private val api: EvolutionService
) {
    // --
    suspend fun getEvolutionFromApi(url: String): EvolutionModelDomain? {
        // --
        return api.getEvolution(url)?.toDomain()
    }
}

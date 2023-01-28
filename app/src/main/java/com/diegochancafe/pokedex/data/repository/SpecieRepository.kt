package com.diegochancafe.pokedex.data.repository

import com.diegochancafe.pokedex.data.network.service.SpecieService
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import com.diegochancafe.pokedex.domain.model.toDomain
import javax.inject.Inject

class SpecieRepository @Inject constructor(
    // -- Injections
    private val api: SpecieService
) {
    // --
    suspend fun getSpecieFromApi(url: String): SpecieModelDomain? {
        // --
        return api.getSpecie(url)?.toDomain()
    }
}

package com.diegochancafe.pokedex.data.repository

import com.diegochancafe.pokedex.data.database.dao.IPokemonDao
import com.diegochancafe.pokedex.data.network.service.PlaceService
import com.diegochancafe.pokedex.data.network.service.PokemonService
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.domain.model.toDomain
import javax.inject.Inject

class PlaceRepository @Inject constructor(
    // -- Injections
    private val api: PlaceService
) {
    // --
    suspend fun getPlacesFromApi(url: String): List<PlaceModelDomain> {
        // --
        val data: MutableList<PlaceModelDomain> = mutableListOf()
        // --
        val result = api.getPlaces(url)
        // --
        return result?.map { it.toDomain() } ?: emptyList()
    }
}

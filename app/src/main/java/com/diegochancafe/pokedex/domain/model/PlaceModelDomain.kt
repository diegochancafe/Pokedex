package com.diegochancafe.pokedex.domain.model

import com.diegochancafe.pokedex.data.model.response.PlaceModelResponse
import java.io.Serializable

// --
data class PlaceModelDomain (
    val locationArea: PokemonInfoDomain
): Serializable

// --
fun PlaceModelResponse.toDomain() = PlaceModelDomain(locationArea.toDomain())
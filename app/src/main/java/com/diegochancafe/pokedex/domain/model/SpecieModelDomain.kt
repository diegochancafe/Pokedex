package com.diegochancafe.pokedex.domain.model

import com.diegochancafe.pokedex.data.model.response.SpecieModelResponse
import java.io.Serializable

// --
data class SpecieModelDomain (
    val evolutionChain: PokemonInfoDomain
): Serializable

// -- Extensions
fun SpecieModelResponse.toDomain() = SpecieModelDomain(evolutionChain.toDomain())
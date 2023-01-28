package com.diegochancafe.pokedex.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class SpecieModelResponse (
    @SerializedName("evolution_chain") val evolutionChain: PokemonInfo,
): Serializable

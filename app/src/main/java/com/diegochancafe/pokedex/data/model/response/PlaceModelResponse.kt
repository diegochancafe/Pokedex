package com.diegochancafe.pokedex.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class PlaceModelResponse (
    @SerializedName("location_area") val locationArea: PokemonInfo,
): Serializable


package com.diegochancafe.pokedex.data.model.response

import com.diegochancafe.pokedex.domain.model.PokemonInfoDomain
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// --
data class EvolutionModelResponse (
    val chain: FirstEvolutionEvolves,
    val id: Int
): Serializable

// -- First Evolution
data class FirstEvolutionEvolves (
    @SerializedName("evolves_to")  val evolvesTo: List<SecondEvolutionEvolves>,
    val species: PokemonInfo
): Serializable

// -- Second Evolution
data class SecondEvolutionEvolves (
    @SerializedName("evolves_to")  val evolvesTo: List<ThirdEvolutionEvolves>,
    val species: PokemonInfo
): Serializable

// -- Third Evolution
data class ThirdEvolutionEvolves (
    val species: PokemonInfo
): Serializable

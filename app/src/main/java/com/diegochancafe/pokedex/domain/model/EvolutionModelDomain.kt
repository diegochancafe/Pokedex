package com.diegochancafe.pokedex.domain.model

import com.diegochancafe.pokedex.data.model.response.EvolutionModelResponse
import com.diegochancafe.pokedex.data.model.response.FirstEvolutionEvolves
import com.diegochancafe.pokedex.data.model.response.SecondEvolutionEvolves
import com.diegochancafe.pokedex.data.model.response.ThirdEvolutionEvolves
import java.io.Serializable

// --
data class EvolutionModelDomain (
    val chain: FirstEvolutionEvolvesDomain,
    val id: Int
): Serializable

// -- First Evolution
data class FirstEvolutionEvolvesDomain (
    val evolvesTo: List<SecondEvolutionEvolvesDomain>,
    val species: PokemonInfoDomain
): Serializable


// -- Second Evolution
data class SecondEvolutionEvolvesDomain (
    val evolvesTo: List<ThirdEvolutionEvolvesDomain>,
    val species: PokemonInfoDomain
): Serializable

// -- Third Evolution
data class ThirdEvolutionEvolvesDomain (
    val species: PokemonInfoDomain
): Serializable

// -- Extensions
fun ThirdEvolutionEvolves.toDomain() = ThirdEvolutionEvolvesDomain(species.toDomain())
fun SecondEvolutionEvolves.toDomain() = SecondEvolutionEvolvesDomain(evolvesTo.map { it.toDomain() }, species.toDomain())
fun FirstEvolutionEvolves.toDomain() = FirstEvolutionEvolvesDomain(evolvesTo.map { it.toDomain() }, species.toDomain())
fun EvolutionModelResponse.toDomain() = EvolutionModelDomain(chain.toDomain(), id)



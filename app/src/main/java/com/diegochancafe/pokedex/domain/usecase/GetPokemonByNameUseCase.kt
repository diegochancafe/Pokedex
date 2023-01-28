package com.diegochancafe.pokedex.domain.usecase

import com.diegochancafe.pokedex.data.repository.PokemonRepository
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import javax.inject.Inject

// --
class GetPokemonByNameUseCase @Inject constructor(private val repository: PokemonRepository) {
    // --
    suspend operator fun invoke(name: String): List<PokemonModelDomain> {
        // --
        return repository.getPokemonByNameFromDatabase(name)
    }
}
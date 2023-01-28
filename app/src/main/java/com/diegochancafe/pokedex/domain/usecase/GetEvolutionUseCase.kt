package com.diegochancafe.pokedex.domain.usecase

import com.diegochancafe.pokedex.data.repository.EvolutionRepository
import com.diegochancafe.pokedex.data.repository.SpecieRepository
import com.diegochancafe.pokedex.domain.model.EvolutionModelDomain
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import javax.inject.Inject

// --
class GetEvolutionUseCase @Inject constructor(private val repository: EvolutionRepository) {
    // --
    suspend operator fun invoke(url: String): EvolutionModelDomain? {
        // --
        return repository.getEvolutionFromApi(url)
    }
}
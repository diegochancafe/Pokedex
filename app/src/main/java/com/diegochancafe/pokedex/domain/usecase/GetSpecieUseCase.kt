package com.diegochancafe.pokedex.domain.usecase

import com.diegochancafe.pokedex.data.repository.SpecieRepository
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import javax.inject.Inject

// --
class GetSpecieUseCase @Inject constructor(private val repository: SpecieRepository) {
    // --
    suspend operator fun invoke(url: String): SpecieModelDomain? {
        // --
        return repository.getSpecieFromApi(url)
    }
}
package com.diegochancafe.pokedex.domain.usecase

import com.diegochancafe.pokedex.data.repository.PlaceRepository
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import javax.inject.Inject

// --
class GetPlacesUseCase @Inject constructor(private val repository: PlaceRepository) {
    // --
    suspend operator fun invoke(url: String): List<PlaceModelDomain> {
        // --
        return repository.getPlacesFromApi(url)
    }
}
package com.diegochancafe.pokedex.data.network.service

import com.diegochancafe.pokedex.data.model.response.PlaceModelResponse
import com.diegochancafe.pokedex.data.network.IRetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// -- Ready for injection
class PlaceService @Inject constructor(private val api: IRetrofitApi) {
    // --
    suspend fun getPlaces(url: String): List<PlaceModelResponse>? {
        // --
        return withContext(Dispatchers.IO) {
            // --
            try {
                // --
                val response = api.getPlaces(url)
                // --
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}
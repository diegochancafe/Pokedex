package com.diegochancafe.pokedex.data.network.service

import android.util.Log
import com.diegochancafe.pokedex.data.model.response.PlaceModelResponse
import com.diegochancafe.pokedex.data.model.response.SpecieModelResponse
import com.diegochancafe.pokedex.data.network.IRetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// -- Ready for injection
class SpecieService @Inject constructor(private val api: IRetrofitApi) {
    // --
    suspend fun getSpecie(url: String): SpecieModelResponse? {
        // --
        return withContext(Dispatchers.IO) {
            // --
            try {
                // --
                val response = api.getSpecie(url)
                // --
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                Log.d("TAG", "getSpecie: ${e.localizedMessage}")
                null
            }
        }
    }
}
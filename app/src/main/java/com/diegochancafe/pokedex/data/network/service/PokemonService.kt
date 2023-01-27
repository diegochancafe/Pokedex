package com.diegochancafe.pokedex.data.network.service

import android.util.Log
import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import com.diegochancafe.pokedex.data.network.IRetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// -- Ready for injection
class PokemonService @Inject constructor(private val api: IRetrofitApi) {
    // --
    suspend fun getPokemon(id: Int): PokemonModelResponse? {
        // --
        return withContext(Dispatchers.IO) {
            // --
            try {
                // --
                val response = api.getPokemon(id)
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
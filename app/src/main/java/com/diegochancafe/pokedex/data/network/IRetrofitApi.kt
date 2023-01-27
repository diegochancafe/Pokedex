package com.diegochancafe.pokedex.data.network

import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IRetrofitApi {
    // --
    @GET("pokemon/{id}/")
    suspend fun getPokemon(
        @Path("id") id: Int,
    ): Response<PokemonModelResponse?>
}
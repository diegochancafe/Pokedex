package com.diegochancafe.pokedex.data.network

import com.diegochancafe.pokedex.data.model.response.EvolutionModelResponse
import com.diegochancafe.pokedex.data.model.response.PlaceModelResponse
import com.diegochancafe.pokedex.data.model.response.PokemonModelResponse
import com.diegochancafe.pokedex.data.model.response.SpecieModelResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url

interface IRetrofitApi {
    // --
    @GET("pokemon/{id}/")
    suspend fun getPokemon(
        @Path("id") id: Int,
    ): Response<PokemonModelResponse?>

    @GET
    suspend fun getPlaces(
        @Url url: String
    ): Response<List<PlaceModelResponse>>

    @GET
    suspend fun getSpecie(
        @Url url: String
    ): Response<SpecieModelResponse>

    @GET
    suspend fun getEvolution(
        @Url url: String
    ): Response<EvolutionModelResponse>
}
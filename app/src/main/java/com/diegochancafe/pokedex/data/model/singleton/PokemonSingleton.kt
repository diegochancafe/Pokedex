package com.diegochancafe.pokedex.data.model.singleton

import com.diegochancafe.pokedex.domain.model.PokemonModelDomain


object PokemonSingleton {
    // --
    var listPokemonModelDomain: List<PokemonModelDomain> = emptyList()
}
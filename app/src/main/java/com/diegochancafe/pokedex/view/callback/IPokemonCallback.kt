package com.diegochancafe.pokedex.view.callback

import com.diegochancafe.pokedex.domain.model.PokemonModelDomain

interface IPokemonCallback {
    fun onItemPokemonClicked(pokemonModelDomain: PokemonModelDomain)
}
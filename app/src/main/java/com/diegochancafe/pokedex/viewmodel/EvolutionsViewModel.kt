package com.diegochancafe.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.pokedex.domain.model.EvolutionModelDomain
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import com.diegochancafe.pokedex.domain.usecase.GetEvolutionUseCase
import com.diegochancafe.pokedex.domain.usecase.GetPlacesUseCase
import com.diegochancafe.pokedex.domain.usecase.GetPokemonByNameUseCase
import com.diegochancafe.pokedex.domain.usecase.GetSpecieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EvolutionsViewModel @Inject constructor(
    // -- Injects
    private val getSpecieUseCase: GetSpecieUseCase,
    private val getEvolutionUseCase: GetEvolutionUseCase,
    private val getPokemonByNameUseCase: GetPokemonByNameUseCase
) : ViewModel() {
    // --
    var pokemonModelDomain: MutableLiveData<List<PokemonModelDomain>> = MutableLiveData()
    var evolutionModelDomain: MutableLiveData<EvolutionModelDomain?> = MutableLiveData()
    var errorMessage = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    // --
    fun getEvolutions(url: String) {
        // --
        isLoading.postValue(true) // -- Loading...
        // --
        viewModelScope.launch {
            // --
            try {
                // --
                val resultSpecie = getSpecieUseCase.invoke(url)
                val resultEvolution = resultSpecie?.evolutionChain?.url?.let {
                    getEvolutionUseCase.invoke(
                        it
                    )
                }
                // --
                evolutionModelDomain.postValue(resultEvolution)
                // --
                isLoading.postValue(false) // -- Finish...

            } catch (e: Exception) {
                // --
                errorMessage.postValue(e.message)
                isLoading.postValue(false) // -- Finish...
            }
        }
    }

    // -- Get id for name
    fun getPokemonByName(name: String) {
        // --
        viewModelScope.launch {
            // --
            try {
                // --
                val result = getPokemonByNameUseCase.invoke(name)
                pokemonModelDomain.postValue(result)
            } catch (e: Exception) {
                // --
            }
        }
    }
}
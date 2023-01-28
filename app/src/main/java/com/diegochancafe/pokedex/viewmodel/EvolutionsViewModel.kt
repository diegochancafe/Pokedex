package com.diegochancafe.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.pokedex.domain.model.EvolutionModelDomain
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import com.diegochancafe.pokedex.domain.usecase.GetEvolutionUseCase
import com.diegochancafe.pokedex.domain.usecase.GetPlacesUseCase
import com.diegochancafe.pokedex.domain.usecase.GetSpecieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EvolutionsViewModel @Inject constructor(
    // -- Injects
    private val getSpecieUseCase: GetSpecieUseCase,
    private val getEvolutionUseCase: GetEvolutionUseCase
) : ViewModel() {
    // --
//    var specieModelDomain: MutableLiveData<SpecieModelDomain?> = MutableLiveData()
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
}
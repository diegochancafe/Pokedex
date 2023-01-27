package com.diegochancafe.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // -- Injects
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    // --
    var pokemonModelDomain: MutableLiveData<List<PokemonModelDomain>> = MutableLiveData()
    var errorMessage = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    // --
    fun getPokemon() {
        // --
        isLoading.postValue(true) // -- Loading...
        // --
        viewModelScope.launch {
            // --
            try {
                // --
                val result = getPokemonUseCase.invoke()
                pokemonModelDomain.postValue(result)
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
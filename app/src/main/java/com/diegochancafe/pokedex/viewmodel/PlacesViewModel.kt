package com.diegochancafe.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import com.diegochancafe.pokedex.domain.usecase.GetPlacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(
    // -- Injects
    private val getPlacesUseCase: GetPlacesUseCase
) : ViewModel() {
    // --
    var placeModelDomain: MutableLiveData<List<PlaceModelDomain>> = MutableLiveData()
    var errorMessage = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    // --
    fun getPlaces(url: String) {
        // --
        isLoading.postValue(true) // -- Loading...
        // --
        viewModelScope.launch {
            // --
            try {
                // --
                val result = getPlacesUseCase.invoke(url)
                placeModelDomain.postValue(result)
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
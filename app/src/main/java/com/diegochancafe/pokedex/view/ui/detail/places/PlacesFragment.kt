package com.diegochancafe.pokedex.view.ui.detail.places

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegochancafe.pokedex.databinding.FragmentPlacesBinding
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.view.ui.detail.places.adapter.PlaceAdapter
import com.diegochancafe.pokedex.viewmodel.PlacesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlacesFragment(private val pokemonModelDomain: PokemonModelDomain) : Fragment() {
    // --
    private val viewModel: PlacesViewModel by viewModels()
    private lateinit var viewBinding: FragmentPlacesBinding
    private lateinit var appContext: Context
    private lateinit var placeAdapter: PlaceAdapter

    // --
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPlacesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    // --
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
        appContext = view.context
        placeAdapter = PlaceAdapter(appContext)
        // --
        setupUI()
        setupViewModel()
    }

    // --
    private fun setupUI() {
        // --
        viewBinding.rvList.apply {
            layoutManager = LinearLayoutManager(appContext, LinearLayoutManager.VERTICAL, false)
            adapter = placeAdapter
        }
    }

    // --
    private fun setupViewModel() {
        // --
        viewModel.getPlaces(pokemonModelDomain.locationAreaEncounters)
        // --
        viewModel.placeModelDomain.observe(this.viewLifecycleOwner, placeModelDomainObserver)
        viewModel.errorMessage.observe(this.viewLifecycleOwner, errorMessageObserver)
        viewModel.isLoading.observe(this.viewLifecycleOwner, isLoadingObserver)
    }

    // --
    private val placeModelDomainObserver = Observer<List<PlaceModelDomain>> { response ->
        // --
        if (response.isEmpty()) {
            viewBinding.tvEmpty.visibility = View.VISIBLE
        } else {
            // --
            viewBinding.tvEmpty.visibility = View.GONE
            placeAdapter.updateData(response)
        }
    }

    // --
    private val isLoadingObserver = Observer<Boolean> { response ->
        // --
        if (!response) {
            // --
        }
    }

    // --
    private val errorMessageObserver = Observer<String> { response ->
        // --
        Toast.makeText(appContext, response, Toast.LENGTH_LONG).show()
    }

}
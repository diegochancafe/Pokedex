package com.diegochancafe.pokedex.view.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.diegochancafe.pokedex.databinding.FragmentHomeBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    // --
    private val viewModel: HomeViewModel by viewModels()
    // --
    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var appContext: Context

    // --
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    // --
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
        appContext = view.context
        setupViewModel()
    }

    // --
    private fun setupViewModel() {
        // --
//        viewBinding.rlFleetsLoader.visibility = View.VISIBLE
        // --
        viewModel.getPokemon()
        // --
        viewModel.pokemonModelDomain.observe(this.viewLifecycleOwner, pokemonModelDomainObserver)
        viewModel.errorMessage.observe(this.viewLifecycleOwner, errorMessageObserver)
        viewModel.isLoading.observe(this.viewLifecycleOwner, isLoadingObserver)
    }

    // --
    private val pokemonModelDomainObserver = Observer<List<PokemonModelDomain>> { response ->
        // --
        Log.d("TAG", "ATRAPALOS YA!: ")
        Log.d("TAG", "$response: ")
    }

    // --
    private val isLoadingObserver = Observer<Boolean> { response ->
        // --
        if (!response) {
            // --
//            viewBinding.srlDevices.isRefreshing = false
//            viewBinding.rlDevicesLoader.visibility = View.GONE
//            // --
//            isReload = false
//            // --
//            checkItemsLength()
//            startInterval()
        }
    }

    // --
    private val errorMessageObserver = Observer<String> { response ->
        // --
        Toast.makeText(appContext, response, Toast.LENGTH_LONG).show()
    }

}
package com.diegochancafe.pokedex.view.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.diegochancafe.pokedex.R
import com.diegochancafe.pokedex.databinding.FragmentHomeBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.view.ui.home.adapter.PokemonAdapter
import com.diegochancafe.pokedex.view.callback.IPokemonCallback
import com.diegochancafe.pokedex.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(), IPokemonCallback {
    // --
    private val viewModel: HomeViewModel by viewModels()
    // --
    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var appContext: Context
    private lateinit var pokemonAdapter: PokemonAdapter

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
        pokemonAdapter = PokemonAdapter(this, appContext)
        // --
        setupUI()
        setupViewModel()
    }

    // --
    private fun setupUI() {
        // --
        viewBinding.rvList.apply {
            layoutManager = GridLayoutManager(appContext, 2)
            adapter = pokemonAdapter
        }
    }

    // --
    private fun setupViewModel() {
        // --
        viewBinding.rlLoader.visibility = View.VISIBLE
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
        Log.d("TAG", "${response.last()}: ")
        pokemonAdapter.updateData(response)
    }

    // --
    private val isLoadingObserver = Observer<Boolean> { response ->
        // --
        if (!response) {
            viewBinding.rlLoader.visibility = View.GONE
        }
    }

    // --
    private val errorMessageObserver = Observer<String> { response ->
        // --
        Toast.makeText(appContext, response, Toast.LENGTH_LONG).show()
    }

    // --
    override fun onItemPokemonClicked(pokemonModelDomain: PokemonModelDomain) {
        // --
        val bundle = bundleOf("pokemonModelDomain" to pokemonModelDomain)
        // --
        findNavController().navigate(R.id.navigationPokemonDetailDialogFragment, bundle)
    }

}
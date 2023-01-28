package com.diegochancafe.pokedex.view.ui.detail.evolutions

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
import com.diegochancafe.pokedex.data.model.singleton.PokemonSingleton
import com.diegochancafe.pokedex.databinding.FragmentEvolutionsBinding
import com.diegochancafe.pokedex.domain.model.*
import com.diegochancafe.pokedex.view.ui.detail.evolutions.adapter.EvolutionAdapter
import com.diegochancafe.pokedex.viewmodel.EvolutionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EvolutionsFragment(private val pokemonModelDomain: PokemonModelDomain) : Fragment() {
    // --
    @Inject
    lateinit var listPokemonSingleton: PokemonSingleton
    // --
    private val viewModel: EvolutionsViewModel by viewModels()
    // --
    private lateinit var viewBinding: FragmentEvolutionsBinding
    private lateinit var appContext: Context
    private lateinit var evolutionAdapter: EvolutionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEvolutionsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
        appContext = view.context
        evolutionAdapter = EvolutionAdapter(appContext, listPokemonSingleton)
        // --
        setupUI()
        setupViewModel()
    }

    // --
    private fun setupUI() {
        // --
        viewBinding.rvList.apply {
            layoutManager = LinearLayoutManager(appContext, LinearLayoutManager.VERTICAL, false)
            adapter = evolutionAdapter
        }
    }

    // --
    private fun setupViewModel() {
        // --
        viewModel.getEvolutions(pokemonModelDomain.species.url!!)
        // --
        viewModel.evolutionModelDomain.observe(this.viewLifecycleOwner, evolutionModelDomainObserver)
        viewModel.errorMessage.observe(this.viewLifecycleOwner, errorMessageObserver)
        viewModel.isLoading.observe(this.viewLifecycleOwner, isLoadingObserver)
    }

    // --
    private val evolutionModelDomainObserver = Observer<EvolutionModelDomain?> { response ->
        // --
        val evolutions: MutableList<PokemonInfoDomain> = mutableListOf()
        if (response != null) {
            // -- First evolution
            evolutions.add(response.chain.species)
            // -- Second evolution
            if (response.chain.evolvesTo.isNotEmpty()) {
                evolutions.add(response.chain.evolvesTo.first().species)
                // -- Third evolution
                if (response.chain.evolvesTo.first().evolvesTo.isNotEmpty()) {
                    evolutions.add(response.chain.evolvesTo.first().evolvesTo.first().species)
                }
            }
            // --
            evolutionAdapter.updateData(evolutions)
            // --
            viewBinding.tvEmptyMessage.visibility = View.GONE
        } else {
            // --
           viewBinding.tvEmptyMessage.visibility = View.VISIBLE
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
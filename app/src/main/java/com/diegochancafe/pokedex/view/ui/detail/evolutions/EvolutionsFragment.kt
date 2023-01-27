package com.diegochancafe.pokedex.view.ui.detail.evolutions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegochancafe.pokedex.databinding.FragmentEvolutionsBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.viewmodel.EvolutionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EvolutionsFragment(pokemonModelDomain: PokemonModelDomain) : Fragment() {

    private lateinit var viewModel: EvolutionsViewModel
    private lateinit var viewBinding: FragmentEvolutionsBinding

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
    }
}
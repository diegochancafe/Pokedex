package com.diegochancafe.pokedex.view.ui.detail.places

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegochancafe.pokedex.databinding.FragmentPlacesBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.viewmodel.PlacesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlacesFragment(pokemonModelDomain: PokemonModelDomain) : Fragment() {

    private lateinit var viewModel: PlacesViewModel
    private lateinit var viewBinding: FragmentPlacesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPlacesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
    }
}
package com.diegochancafe.pokedex.view.ui.detail.attacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegochancafe.pokedex.databinding.FragmentAttacksBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.viewmodel.AttacksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttacksFragment(pokemonModelDomain: PokemonModelDomain) : Fragment() {
    // --
    private lateinit var viewModel: AttacksViewModel
    private lateinit var viewBinding: FragmentAttacksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentAttacksBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
    }

}
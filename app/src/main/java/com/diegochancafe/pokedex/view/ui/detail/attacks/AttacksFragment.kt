package com.diegochancafe.pokedex.view.ui.detail.attacks

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegochancafe.pokedex.databinding.FragmentAttacksBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.domain.model.PokemonMoveDomain
import com.diegochancafe.pokedex.view.ui.detail.attacks.adapter.AttackAdapter
import com.diegochancafe.pokedex.viewmodel.AttacksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttacksFragment(private val pokemonModelDomain: PokemonModelDomain) : Fragment() {
    // --
    private val viewModel: AttacksViewModel by viewModels()
    // --
    private lateinit var viewBinding: FragmentAttacksBinding
    private lateinit var attackAdapter: AttackAdapter
    private lateinit var appContext: Context

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
        appContext = view.context
        attackAdapter = AttackAdapter(appContext)
        // --
        setupUI()
        setData()
    }

    // --
    private fun setupUI() {
        // --
        viewBinding.rvList.apply {
            layoutManager = LinearLayoutManager(appContext, LinearLayoutManager.VERTICAL, false)
            adapter = attackAdapter
        }
    }

    // --
    private fun setData() {
        // --
        val list: List<PokemonMoveDomain> = pokemonModelDomain.moves
        attackAdapter.updateData(list)
    }

}
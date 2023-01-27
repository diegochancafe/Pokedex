package com.diegochancafe.pokedex.view.ui.detail

import android.content.Context
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.diegochancafe.pokedex.R
import com.diegochancafe.pokedex.databinding.FragmentPokemonDetailDialogBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.viewmodel.PokemonDetailDialogViewModel
import dagger.hilt.android.AndroidEntryPoint

// --
@AndroidEntryPoint
class PokemonDetailDialogFragment : DialogFragment() {
    // --
    companion object {
        fun newInstance() = PokemonDetailDialogFragment()
    }
    // --
    private lateinit var viewBinding: FragmentPokemonDetailDialogBinding
    private lateinit var viewModel: PokemonDetailDialogViewModel
    private lateinit var appContext: Context
    private lateinit var pokemonModelDomain: PokemonModelDomain

    // --
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    // --
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPokemonDetailDialogBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --
        appContext = view.context
        pokemonModelDomain = arguments?.getSerializable("pokemonModelDomain") as PokemonModelDomain
        // --
        viewBinding.fabClose.setColorFilter(Color.WHITE)
        viewBinding.fabClose.setOnClickListener {
            dismiss()
        }
        // --
        setDataForDetail()
    }

    private fun setDataForDetail() {
        // --
        if (pokemonModelDomain.abilities.isNotEmpty()) {
            // --
            val count = pokemonModelDomain.abilities.count()
            viewBinding.tvAbilityOne.text = pokemonModelDomain.abilities.first().ability.name
            // --
            if (count > 1) {
                viewBinding.tvAbilityTwo.visibility = View.VISIBLE
                viewBinding.tvAbilityTwo.text = pokemonModelDomain.abilities.last().ability.name
            } else {
                viewBinding.tvAbilityTwo.visibility = View.GONE
            }
        }

        // --
        if (pokemonModelDomain.types.isNotEmpty()) {
            // --
            val count = pokemonModelDomain.types.count()
            viewBinding.tvTypeOne.text = pokemonModelDomain.types.first().type.name
            // --
            if (count > 1) {
                viewBinding.tvTypeTwo.visibility = View.VISIBLE
                viewBinding.tvTypeTwo.text = pokemonModelDomain.types.last().type.name
            } else {
                viewBinding.tvTypeTwo.visibility = View.GONE
            }
        }

        // --
        viewBinding.tvName.text = pokemonModelDomain.name.uppercase()
        Glide.with(appContext)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonModelDomain.id}.png")
            .fitCenter()
            .into(viewBinding.ivPhoto)
    }

    // --
    override fun onStart() {
        super.onStart()
        // --
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}
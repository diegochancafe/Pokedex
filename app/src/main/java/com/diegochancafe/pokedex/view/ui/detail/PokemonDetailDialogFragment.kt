package com.diegochancafe.pokedex.view.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.diegochancafe.pokedex.R
import com.diegochancafe.pokedex.databinding.FragmentPokemonDetailDialogBinding
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
package com.diegochancafe.pokedex.view.ui.detail.evolutions.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diegochancafe.pokedex.data.model.singleton.PokemonSingleton
import com.diegochancafe.pokedex.databinding.ViewEvolutionItemBinding
import com.diegochancafe.pokedex.domain.model.PokemonInfoDomain
import java.util.ArrayList

class EvolutionAdapter(private val appContext: Context, private val listPokemonSingleton: PokemonSingleton): RecyclerView.Adapter<EvolutionAdapter.ViewHolder>() {
    // --
    private var list = ArrayList<PokemonInfoDomain>()

    // --
    class ViewHolder(viewBinding: ViewEvolutionItemBinding): RecyclerView.ViewHolder(viewBinding.root) {
        // --
        val itemDescription: TextView = viewBinding.tvDescription
        val itemPhoto: ImageView = viewBinding.ivPhoto
    }

    // --
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewEvolutionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // --
    override fun getItemCount(): Int {
        return list.size
    }

    // --
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // --
        val data: PokemonInfoDomain = list[position]
        // --
        holder.itemDescription.text = data.name!!.replace("-", " ")
        val pokemonModelDomain = listPokemonSingleton.listPokemonModelDomain.find { it.name == data.name }
        Glide.with(appContext)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonModelDomain?.id}.png")
            .fitCenter()
            .into(holder.itemPhoto)
    }

    // --
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<PokemonInfoDomain>) {
        // --
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}
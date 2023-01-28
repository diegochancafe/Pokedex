package com.diegochancafe.pokedex.view.ui.detail.evolutions.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diegochancafe.pokedex.databinding.ViewTextItemBinding
import com.diegochancafe.pokedex.domain.model.PokemonInfoDomain
import com.diegochancafe.pokedex.domain.model.PokemonMoveDomain
import com.diegochancafe.pokedex.domain.model.SpecieModelDomain
import java.util.ArrayList

class EvolutionAdapter(private val appContext: Context): RecyclerView.Adapter<EvolutionAdapter.ViewHolder>() {
    // --
    private var list = ArrayList<PokemonInfoDomain>()

    // --
    class ViewHolder(viewBinding: ViewTextItemBinding): RecyclerView.ViewHolder(viewBinding.root) {
        // --
//        val item: LinearLayout = viewBinding.lyItem
        val itemDescription: TextView = viewBinding.tvDescription
    }

    // --
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewTextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
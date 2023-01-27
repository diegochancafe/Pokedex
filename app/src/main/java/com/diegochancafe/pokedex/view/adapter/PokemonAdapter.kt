package com.diegochancafe.pokedex.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diegochancafe.pokedex.databinding.ViewPokemonItemBinding
import com.diegochancafe.pokedex.domain.model.PokemonModelDomain
import com.diegochancafe.pokedex.util.Config
import com.diegochancafe.pokedex.view.callback.IPokemonCallback
import java.util.ArrayList


class PokemonAdapter(private val listener: IPokemonCallback, private val appContext: Context): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    // --
    private var list = ArrayList<PokemonModelDomain>()

    // --
    class ViewHolder(viewBinding: ViewPokemonItemBinding): RecyclerView.ViewHolder(viewBinding.root) {
        // --
        val item: LinearLayout = viewBinding.lyItem
        val itemName: TextView = viewBinding.tvName
        val itemPhoto: ImageView = viewBinding.ivPhoto
    }

    // --
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // --
    override fun getItemCount(): Int {
        return list.size
    }

    // --
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // --
        val data: PokemonModelDomain = list[position]
        // --
        holder.itemName.text = data.name
        Glide.with(appContext)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${data.id}.png")
            .fitCenter()
            .into(holder.itemPhoto)
        // --
        holder.item.setOnClickListener {
            listener.onItemPokemonClicked(data)
        }

    }

    // --
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<PokemonModelDomain>) {
        // --
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}
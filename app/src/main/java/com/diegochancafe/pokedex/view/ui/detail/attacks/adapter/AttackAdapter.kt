package com.diegochancafe.pokedex.view.ui.detail.attacks.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diegochancafe.pokedex.databinding.ViewTextItemBinding
import com.diegochancafe.pokedex.domain.model.PokemonMoveDomain
import java.util.ArrayList

class AttackAdapter(private val appContext: Context): RecyclerView.Adapter<AttackAdapter.ViewHolder>() {
    // --
    private var list = ArrayList<PokemonMoveDomain>()

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
        val data: PokemonMoveDomain = list[position]
        // --
        holder.itemDescription.text = data.move.name!!.replace("-", " ")
    }

    // --
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<PokemonMoveDomain>) {
        // --
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}
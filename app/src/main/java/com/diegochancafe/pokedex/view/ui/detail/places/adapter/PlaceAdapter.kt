package com.diegochancafe.pokedex.view.ui.detail.places.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diegochancafe.pokedex.databinding.ViewTextItemBinding
import com.diegochancafe.pokedex.domain.model.PlaceModelDomain
import java.util.ArrayList

// --
class PlaceAdapter(private val appContext: Context): RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    // --
    private var list = ArrayList<PlaceModelDomain>()

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
        val data: PlaceModelDomain = list[position]
        // --
        holder.itemDescription.text = data.locationArea.name.replace("-", " ")
    }

    // --
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<PlaceModelDomain>) {
        // --
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}
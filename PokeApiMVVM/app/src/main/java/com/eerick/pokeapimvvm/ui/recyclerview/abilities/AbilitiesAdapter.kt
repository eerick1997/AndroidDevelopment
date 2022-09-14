package com.eerick.pokeapimvvm.ui.recyclerview.abilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eerick.pokeapimvvm.R

class AbilitiesAdapter (private var abilities: List<String>) :
    RecyclerView.Adapter<AbilitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AbilitiesViewHolder(layoutInflater.inflate(R.layout.ability_item, parent, false))
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        val item = abilities[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = abilities.size

    fun setAbilities(abilities: List<String>) {
        this.abilities = abilities
        notifyDataSetChanged()
    }
}
package com.eerick.doggosappp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eerick.doggosappp.R

class DogsAdapter(private val dogsImages: List<String>) : RecyclerView.Adapter<DogsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogsViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false))
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val item = dogsImages[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = dogsImages.size
}
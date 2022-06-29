package com.eerick.doggosmvvm.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eerick.doggosmvvm.R
import com.eerick.doggosmvvm.domain.model.Dog

class DogsRecyclerViewAdapter(
    private var dogsList: List<Dog>
) : RecyclerView.Adapter<DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.dog_card, parent, false))
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        val item = dogsList[position]
        dogViewHolder.render(item)
    }

    override fun getItemCount(): Int = dogsList.size

    fun setList(dogsList: List<Dog>) {
        this.dogsList = dogsList
        notifyDataSetChanged()
    }
}
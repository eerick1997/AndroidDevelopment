package com.eerick.doggosappp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eerick.doggosappp.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemDogBinding.bind(view)

    fun render(imageUrl: String) {
        Picasso.get().load(imageUrl).into(binding.imageDog)
    }
}
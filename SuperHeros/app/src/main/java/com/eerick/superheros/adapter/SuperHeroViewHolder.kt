package com.eerick.superheros.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eerick.superheros.SuperHero
import com.eerick.superheros.databinding.ItemSuperHeroBinding

class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemSuperHeroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener: (SuperHero) -> Unit) {
        val (name, realName, publisher, url) = superHeroModel
        binding.textSuperHeroName.text = name
        binding.textSuperHeroRealName.text = realName
        binding.textSuperHeroPublisher.text = publisher
        Glide.with(view.context).load(url).into(binding.imageSuperHero)
        itemView.setOnClickListener { onClickListener(superHeroModel) }
    }
}
package com.eerick.pokeapimvvm.ui.recyclerview.abilities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eerick.pokeapimvvm.databinding.AbilityItemBinding

class AbilitiesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = AbilityItemBinding.bind(view)
    fun render(ability: String) {
        binding.TVAbilityName.text = ability
            .replace('-', ' ')
            .replaceFirstChar { letter -> letter.uppercaseChar() }
    }
}
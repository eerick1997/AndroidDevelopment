package com.eerick.doggosmvvm.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eerick.doggosmvvm.databinding.DogCardBinding
import com.eerick.doggosmvvm.domain.model.Dog

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = DogCardBinding.bind(view)
    fun render(dogModel: Dog) {
        val (name, description, age, image) = dogModel
        binding.txtPetName.text = name
        binding.txtPetDescription.text = description
        binding.txtPetAge.text = ageTextManager(age)
        binding.SDVImageDogo.setImageURI(image)
    }

    private fun ageTextManager(age: Int) : String {
        return "$age year${if (age > 1) "s" else ""}"
    }
}
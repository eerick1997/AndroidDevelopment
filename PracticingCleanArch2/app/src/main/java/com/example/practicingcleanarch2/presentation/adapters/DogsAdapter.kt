package com.example.practicingcleanarch2.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicingcleanarch2.databinding.DogItemBinding

class DogsAdapter : RecyclerView.Adapter<DogsAdapter.DogViewHolder>() {

    class DogViewHolder(val binding: DogItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    var dogsList
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(DogItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val currentImage = dogsList[position]
        holder.apply {
            Glide.with(itemView)
                .load(currentImage)
                .into(binding.ivDogImage)
        }
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }
}
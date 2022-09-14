package com.example.runningapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runningapp.R
import com.example.runningapp.databinding.ItemRunBinding
import com.example.runningapp.db.Run
import com.example.runningapp.other.TrackingUtility
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    inner class RunViewHolder(val binding: ItemRunBinding) : RecyclerView.ViewHolder(binding.root)

    val diffCallback = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            ItemRunBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run = differ.currentList[position]
        with(holder) {
            Glide.with(this.itemView).load(run.img).into(binding.ivRunImage)
            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            binding.tvDate.text = dateFormat.format(calendar.time)
            val averageSpeed = "${run.avgSpeedInKMH}km/h"
            binding.tvAvgSpeed.text = averageSpeed
            val distanceInKm = "${run.distanceInMeters / 1000f}km"
            binding.tvDistance.text = distanceInKm
            binding.tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
            val caloriesBurned = "${run.caloriesBurned}kcal"
            binding.tvCalories.text = caloriesBurned
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
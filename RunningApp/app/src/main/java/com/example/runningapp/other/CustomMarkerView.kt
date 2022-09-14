package com.example.runningapp.other

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import com.example.runningapp.R
import com.example.runningapp.databinding.MarkerViewBinding
import com.example.runningapp.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    private val runs: List<Run>,
    context: Context,
    @LayoutRes layoutId: Int
) : MarkerView(context, layoutId) {

    private lateinit var binding: MarkerViewBinding

    init {
        binding = MarkerViewBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null) {
            return
        }
        val currRunId = e.x.toInt()
        val run = runs[currRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        binding.tvDate.text = dateFormat.format(calendar.time)
        val averageSpeed = "${run.avgSpeedInKMH}km/h"
        binding.tvAvgSpeed.text = averageSpeed
        val distanceInKm = "${run.distanceInMeters / 1000f}km"
        binding.tvDistance.text = distanceInKm
        binding.tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
        val caloriesBurned = "${run.caloriesBurned}kcal"
        binding.tvCaloriesBurned.text = caloriesBurned
    }
}
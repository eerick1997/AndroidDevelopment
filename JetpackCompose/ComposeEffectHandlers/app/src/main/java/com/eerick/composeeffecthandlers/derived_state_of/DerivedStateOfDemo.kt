package com.eerick.composeeffecthandlers.derived_state_of

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*

/**
 * Let's assume that we have:
 * val counterText = "The counter is $counter"
 * instead of:
 * val counterText by derivedStateOf { "The counter is $counter" }
 * The problem with that is, every time counter is updated the counter text is recomputed.
 * What recomputed means here is that the string is concatenated again and again something like
 * val counterText = "The counter is " + counter
 * And every time, someone reads counterText the same computation will make again.
 * Basically if you have some complex behaviour that depends of state and changes over time.
 * derivedState caches the string, when the Widget Text uses the counterText now it will
 * use the cashed version of the string so it won't recompute the string.
 * */
@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    val counterText by derivedStateOf { "The counter is $counter" }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}
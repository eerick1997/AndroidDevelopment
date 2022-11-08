package com.eerick.composeeffecthandlers.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

/**
 * produceState is a composable function. This function gives us a CoroutineScope like the
 * launchedEffect. The purpose of produceState is to gives us a state that changes over the time
 * (yes like a flow)
 * */
@Composable
fun ProduceStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000L)
            value++
        }
    }
}
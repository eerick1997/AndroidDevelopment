package com.eerick.composeeffecthandlers.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

/**
 * In this example we want to execute the onTimeout lambda function just once. As you can assume
 * we achieve that behaviour using LaunchedEffect with "key1 = true" the interesting thing is:
 * If we update the onTimeout function the launchedEffect block won't update the onTimeOut()
 * callback. If we want to update the onTimeout we use rememberUpdatedState. rememberUpdatedState
 * is a composable function which purpose is to update things if needed. In our example when the
 * onTimeout parameter is updated the updatedOnTimeout variable will be updated too and we can
 * guarantee that inside the LaunchEffect block we will have the latest onTimeout value received.
 * */
@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
) {

    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}
package com.eerick.composeeffecthandlers.disposable_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver

/**
 * If we want to intercept lifecycle callback we will have a problem because in every
 * recomposition the lifecycleOwner will be created again and the observer will have the same
 * behaviour. You will think that we can fix that problem using a LaunchedEffect block but
 * that's not true because the observer must be cleaned up every after being used it means
 * when the composable leaves the composition. To achieve that instead of a LaunchedEffect we
 * use a DisposableEffect. It is pretty similar to LaunchedEffect, we must add a "key1" param.
 * For our particular case we pass the lifecycleOwner as the key. Something that you must
 * be aware is to implement the onDispose function.
 *
 * Basically when you need to make some clean up, you must use the DisposableEffect.
 * */
@Composable
fun DisposableEffectDemo() {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On pause called")
            }
        }
        // We subscribe an observer to our lifecycle then we must remove it
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            // When we leave the composition we remove the observer
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
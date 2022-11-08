package com.eerick.composeeffecthandlers.launched_effect

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

/**
 * Other useful case for LaunchedEffect is with animations.
 * In this case when the counter value changes the coroutine is cancelled and relaunched
 * with the new value.
 * */
@Composable
fun LaunchedEffectAnimation(
    counter: Int
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat())
    }
}
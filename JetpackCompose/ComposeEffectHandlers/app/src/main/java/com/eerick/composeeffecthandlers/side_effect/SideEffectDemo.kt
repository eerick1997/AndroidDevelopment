package com.eerick.composeeffecthandlers.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

/**
 * SideEffect gets called when you composable is successfully recomposed.
 *
 * */
@Composable
fun SideEffectDemo(nonComposeCounter: Int) {
    SideEffect {
        println("Called after very successful recomposition")
    }
}
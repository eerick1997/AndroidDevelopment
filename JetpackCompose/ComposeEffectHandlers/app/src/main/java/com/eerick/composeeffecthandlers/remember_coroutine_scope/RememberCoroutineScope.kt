package com.eerick.composeeffecthandlers.remember_coroutine_scope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * rememberCoroutineScope is a composable function that gives us a reference to a coroutineScope
 * that is aware of the composition. If you want to launch a coroutine is mandatory to use
 * this scope. Something that you must remember is, you would use this only for callbacks, for
 * example the onClick of a button. Things like a network call is a bad practice! In that case
 * if you make a network call in every recomposition you will do new network call.
 * */
@Composable
fun RememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World!")
        }
    }) {

    }
}
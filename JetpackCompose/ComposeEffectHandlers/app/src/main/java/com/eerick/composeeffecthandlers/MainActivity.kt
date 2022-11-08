package com.eerick.composeeffecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import com.eerick.composeeffecthandlers.ui.theme.ComposeEffectHandlersTheme
import kotlinx.coroutines.delay

/**
 * LaunchedEffect: Allow us to run suspend functions because we have a CoroutineScope.
 * Basically a LaunchedEffect block is a composable that means we can use them only in
 * composable functions. In the "key1" parameter we can assign for example a State; That means
 * whenever the state changes ("text" in our example) the coroutine will be canceled and
 * relaunched with the new "text" value
 * */
class MainActivity : ComponentActivity() {

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            ComposeEffectHandlersTheme {
                LaunchedEffect(key1 = text) {
                    delay(1000L)
                    println("The text is $text")
                }
            }
        }
    }
}

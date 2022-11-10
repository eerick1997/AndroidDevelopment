package com.eerick.meditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eerick.meditationui.ui.HomeScreen
import com.eerick.meditationui.ui.theme.MeditationUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUI {
                HomeScreen()
            }
        }
    }
}
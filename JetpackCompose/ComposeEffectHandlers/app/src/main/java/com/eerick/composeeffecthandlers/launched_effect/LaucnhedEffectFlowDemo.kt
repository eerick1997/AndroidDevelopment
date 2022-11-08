package com.eerick.composeeffecthandlers.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.collect

/**
 * In this case as the LaunchedEffect has in the parameter "key1" the true value, it will
 * be executed only once. In this case use true as "key1" allows us to safely collect
 * the value of our sharedFlow.
 * */
@Composable
fun LaunchedEffectFlowDemo(
    viewModel: LaunchedEffectViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.sharedFlow.collect { event ->
            when(event) {
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackbar -> {

                }
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
            }
        }
    }
}
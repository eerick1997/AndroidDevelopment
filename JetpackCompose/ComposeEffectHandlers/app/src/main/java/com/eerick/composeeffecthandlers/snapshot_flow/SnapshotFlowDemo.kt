package com.eerick.composeeffecthandlers.snapshot_flow

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

/**
 * If you're using a flow and you want to use it with Compose you can call to .collectAsState()
 * if we want the opposite you should use snapshotFlow
 * */
@Composable
fun SnapshotFlowDemo() {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = scaffoldState) {
        snapshotFlow { scaffoldState.snackbarHostState }
            .mapNotNull { it.currentSnackbarData?.message }
            .distinctUntilChanged()
            .collect { message ->
                println("A snackbar with message $message was shown")
            }
    }
}
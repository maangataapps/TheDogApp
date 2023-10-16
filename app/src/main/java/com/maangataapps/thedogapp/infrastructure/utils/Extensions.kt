package com.maangataapps.thedogapp.infrastructure.utils

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.presentation.composables.RedSnackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object Extensions {

    fun Boolean.ifTrue(actionIfTrue: () -> Unit) {
        if (this) actionIfTrue.invoke()
    }

    @Composable
    fun CardDefaults.defaultCardElevation(): CardElevation {
        return cardElevation(
            defaultElevation = Dimens.Elevation.Normal.dp
        )
    }

    @Composable
    fun String.ShowSnackbarWithMessage(
        modifier: Modifier,
        snackbarHostState: SnackbarHostState,
        scope: CoroutineScope
    ) {
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = modifier
        ) { snackbarData ->
            RedSnackbar(modifier = modifier, snackbarData = snackbarData)
        }
        val message = this
        LaunchedEffect(key1 = "key1", block = {
            scope.launch {
                snackbarHostState.showSnackbar(
                    message,
                    duration = SnackbarDuration.Short,
                    withDismissAction = false,
                )
            }
        })
    }
    
}
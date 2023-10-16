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
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.presentation.composables.RedSnackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object Extensions {

    fun Boolean.ifTrue(actionIfTrue: () -> Unit) {
        if (this) actionIfTrue.invoke()
    }

    fun Boolean.ifFalse(actionIfTrue: () -> Unit) {
        if (!this) actionIfTrue.invoke()
    }

    @Composable
    fun Boolean.IfTrueOrFalse(actionIfTrue: @Composable () -> Unit, actionIfFalse: @Composable () -> Unit) {
        if (this) {
            actionIfTrue.invoke()
        } else {
            actionIfFalse.invoke()
        }
    }

    fun String?.orFillEmptyField(): String {
        return if (this.isNullOrEmpty()) "-" else this
    }

    fun String.showTextInSnackbar(scope: CoroutineScope, snackbarHostState: SnackbarHostState) {
        scope.launch {
            snackbarHostState.showSnackbar(this@showTextInSnackbar)
        }
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

    fun <T>NetworkUtils.checkConnectionAndDo(
        connected: () -> T,
        disconnected: () -> T
    ): T {
        return if (isOnline()) {
            connected.invoke()
        } else {
            disconnected.invoke()
        }
    }

    fun BreedDetails?.orEmpty(): BreedDetails {
        return this
            ?: BreedDetails(
                id = 0,
                name = "",
                category = "",
                origin = "",
                temperament = ""
            )
    }

    fun BreedDetails?.allFieldsEmpty(): Boolean {
        return this?.id == null &&
                this?.name.isNullOrEmpty() &&
                this?.category.isNullOrEmpty() &&
                this?.origin.isNullOrEmpty() &&
                this?.temperament.isNullOrEmpty()
    }

}
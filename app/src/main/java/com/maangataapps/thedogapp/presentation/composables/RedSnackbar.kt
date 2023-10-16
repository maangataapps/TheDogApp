package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RedSnackbar(
    modifier: Modifier,
    snackbarData: SnackbarData
) {
    Snackbar(
        modifier = modifier,
        snackbarData = snackbarData,
        containerColor = Color.Red
    )
}
package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.maangataapps.thedogapp.R

@Composable
fun LoadingLayer(
    modifier: Modifier,
    alpha: Float,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .alpha(alpha),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = modifier,
                text = stringResource(id = R.string.loading),
                fontSize = 30.sp,
            )
            CircularProgressIndicator()
        }
    }

}
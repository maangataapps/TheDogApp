package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.infrastructure.utils.Dimens

@Composable
fun DogAppTopBar(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shadowElevation = Dimens.Elevation.Normal.dp,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 400.dp, max = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier.padding(end = Dimens.Padding.Small.dp),
                painter = painterResource(id = R.drawable.footprint),
                contentDescription = null
            )
            Text(
                modifier = modifier,
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                modifier = modifier.padding(start = Dimens.Padding.Small.dp),
                painter = painterResource(id = R.drawable.footprint),
                contentDescription = null
            )
        }
    }

}
package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.defaultCardElevation

@Composable
fun NoSearchCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(Dimens.Padding.Normal.dp)
            .height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.defaultCardElevation(),
    ) {
        Column(modifier = modifier) {
            Text(
                modifier = modifier.padding(Dimens.Padding.Large.dp),
                text = stringResource(id = R.string.no_search),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(3) {
                    Icon(
                        modifier = modifier.padding(Dimens.Padding.Large.dp),
                        painter = painterResource(R.drawable.footprint),
                        contentDescription = null,
                    )
                }
            }
        }
    }

}
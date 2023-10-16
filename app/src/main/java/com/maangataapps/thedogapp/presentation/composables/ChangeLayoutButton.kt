package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.presentation.breedsscreen.view.ChangeLayoutType

@Composable
fun ChangeLayoutButton(
    modifier: Modifier,
    layoutSelected: Int,
    changeLayoutType: ChangeLayoutType
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(Dimens.Roundness.Normal.dp))
            .padding(Dimens.Padding.Small.dp)
            .background(
                if (layoutSelected == changeLayoutType.id) Color.White else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)
            )
            .border(
                Dimens.Border.Normal.dp,
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)
            )
    ) {
        IconButton(
            modifier = modifier
                .border(
                    Dimens.Border.None.dp,
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)
                )
                .clip(shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)),
            onClick = { changeLayoutType.onClick?.invoke() }
        )
        {
            Icon(
                modifier = modifier,
                painter = painterResource(id = changeLayoutType.icon),
                contentDescription = null,
            )
        }
    }
}
package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.presentation.breedsscreen.view.ChangeLayoutType

@Composable
fun ChangeBreedsLayout(
    modifier: Modifier,
    layoutSelected: Int,
    onClickListLayout: () -> Unit,
    onClickGridLayout: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium,
        ) {
            Row(
                modifier = modifier
                .shadow(elevation = Dimens.Elevation.Small.dp)
                .border(
                    Dimens.Border.Normal.dp,
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)
                ))
            {
                ChangeLayoutButton(
                    modifier = modifier,
                    changeLayoutType = ChangeLayoutType.ChangeToList(onClick = { onClickListLayout.invoke() }),
                    layoutSelected = layoutSelected
                )
                ChangeLayoutButton(
                    modifier = modifier,
                    changeLayoutType = ChangeLayoutType.ChangeToGrid(onClick = { onClickGridLayout.invoke() }),
                    layoutSelected = layoutSelected
                )
            }
        }
    }

}
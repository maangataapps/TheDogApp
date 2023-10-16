package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.infrastructure.utils.Dimens

@Composable
fun BreedSearchItem(
    modifier: Modifier,
    breed: BreedSearch,
    onClickBreed: (Int) -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.Padding.Normal.dp)
            .clickable { onClickBreed.invoke(breed.id!!) },
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(Dimens.Roundness.Normal.dp),
    ) {
        Column(
            modifier = modifier.padding(Dimens.Padding.Normal.dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.Padding.Normal.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = modifier.padding(start = Dimens.Padding.Normal.dp),
                text = breed.name.orEmpty(),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = modifier,
                text = breed.group.orEmpty(),
                textAlign = TextAlign.Start,
            )
            Text(
                modifier = modifier,
                text = if (breed.origin.isNullOrEmpty()) "-" else breed.origin,
                textAlign = TextAlign.Start,
            )
        }
    }

}
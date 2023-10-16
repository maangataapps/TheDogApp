package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Dimens

@Composable
fun BreedsListview(
    modifier: Modifier,
    breedsList: LazyPagingItems<Breed>,
    onClickBreed: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.Normal.dp)
    ) {
        items(count = breedsList.itemCount) { index ->
            breedsList[index]?.let { breed ->
                BreedListItem(
                    modifier = modifier,
                    breed = breed,
                    onClick = { onClickBreed.invoke(breed.id) },
                )
            }
        }
    }

}


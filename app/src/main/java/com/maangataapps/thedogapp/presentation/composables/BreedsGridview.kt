package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Dimens

@Composable
fun BreedsGridview(
    modifier: Modifier,
    breedsList: LazyPagingItems<Breed>,
    onClickBreed: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier.padding(Dimens.Padding.Normal.dp),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.Normal.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.Normal.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(count = breedsList.itemCount) { index ->
            breedsList[index]?.let { breed ->
                BreedGridItem(
                    modifier = modifier,
                    breed = breed,
                    onClick = { onClickBreed.invoke(breed.id) },
                )
            }
        }
    }

}
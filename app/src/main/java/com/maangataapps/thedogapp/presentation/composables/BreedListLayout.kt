package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.ShowSnackbarWithMessage
import com.maangataapps.thedogapp.presentation.breedsscreen.view.LayoutId

@Composable
fun BreedListLayout(
    modifier: Modifier,
    breedsList: LazyPagingItems<Breed>,
    selectedLayout: Int,
    onClickBreed: (Int) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    when (selectedLayout) {
        LayoutId.List.ordinal -> {
            BreedsListview(
                modifier = modifier,
                breedsList = breedsList,
                onClickBreed = { breedId -> onClickBreed.invoke(breedId) },
            )
        }
        LayoutId.Grid.ordinal -> {
            BreedsGridview(
                modifier = modifier,
                breedsList = breedsList,
                onClickBreed = { breedId -> onClickBreed.invoke(breedId) },
            )
        }
    }

    breedsList.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                LoadingLayer(modifier = modifier, alpha = Dimens.Alpha.Normal)
            }
            loadState.append is LoadState.Error || loadState.refresh is LoadState.Error -> {
                stringResource(id = R.string.paging_error)
                    .ShowSnackbarWithMessage(modifier, snackbarHostState, scope)
            }
        }
    }

}
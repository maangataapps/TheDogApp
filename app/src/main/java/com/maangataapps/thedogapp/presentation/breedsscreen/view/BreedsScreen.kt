package com.maangataapps.thedogapp.presentation.breedsscreen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.presentation.breedsscreen.viewmodel.BreedsViewmodel
import com.maangataapps.thedogapp.presentation.composables.BreedListLayout
import com.maangataapps.thedogapp.presentation.composables.ChangeBreedsLayout
import com.maangataapps.thedogapp.presentation.composables.DogAppBottomNavigation
import com.maangataapps.thedogapp.presentation.composables.DogAppTopBar

@Composable
fun BreedsScreen(
    modifier: Modifier = Modifier,
    viewModel: BreedsViewmodel,
    navigateToBreedsScreen: () -> Unit,
    navigateToSearchScreen: () -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
) {
    val breedsList = viewModel.breedsList.collectAsLazyPagingItems()
    var selectedLayout by rememberSaveable { mutableIntStateOf(ChangeLayoutType.ChangeToList().id) }

    Scaffold(
        modifier = modifier.fillMaxWidth(),
        topBar = { DogAppTopBar(modifier) },
        bottomBar = {
            DogAppBottomNavigation(
                modifier = modifier,
                routeOrdinal = BottomTabButtonType.Breeds.ordinal,
                onClickBreeds = { navigateToBreedsScreen.invoke() },
                onClickSearch = { navigateToSearchScreen.invoke() },
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(top = Dimens.Padding.Normal.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = modifier.padding(bottom = Dimens.Padding.Normal.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Box(modifier = modifier) {
                    ChangeBreedsLayout(
                        modifier = modifier,
                        layoutSelected = selectedLayout,
                        onClickListLayout = { selectedLayout = LayoutId.List.ordinal },
                        onClickGridLayout = { selectedLayout = LayoutId.Grid.ordinal }
                    )
                }
            }
            BreedListLayout(
                modifier = modifier,
                breedsList = breedsList,
                selectedLayout = selectedLayout,
                onClickBreed = { breedId -> navigateToDetailScreen.invoke(breedId) }
            )
        }
    }

}
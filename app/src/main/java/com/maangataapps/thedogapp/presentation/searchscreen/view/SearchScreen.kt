package com.maangataapps.thedogapp.presentation.searchscreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.IfTrueOrFalse
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.ifTrue
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.showTextInSnackbar
import com.maangataapps.thedogapp.presentation.breedsscreen.view.BottomTabButtonType
import com.maangataapps.thedogapp.presentation.composables.BreedSearchItem
import com.maangataapps.thedogapp.presentation.composables.DogAppBottomNavigation
import com.maangataapps.thedogapp.presentation.composables.NoSearchCard
import com.maangataapps.thedogapp.presentation.composables.RedSnackbar
import com.maangataapps.thedogapp.presentation.composables.SearchBar
import com.maangataapps.thedogapp.presentation.searchscreen.viewmodel.SearchViewmodel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewmodel,
    navigateToBreedsScreen: () -> Unit,
    navigateToSearchScreen: () -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
) {
    val breedInfo by viewModel.breedInfo.observeAsState()
    val onError by viewModel.onError.observeAsState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            DogAppBottomNavigation(
                routeOrdinal = BottomTabButtonType.Search.ordinal,
                onClickBreeds = { navigateToBreedsScreen.invoke() },
                onClickSearch = { navigateToSearchScreen.invoke() },
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                RedSnackbar(modifier = modifier, snackbarData = snackbarData)
            }
                       },
    ) { padding ->
        Column(
            modifier = modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar(
                modifier = modifier,
                onSearchBreed = { breedName ->
                    breedName.isNotEmpty().ifTrue { viewModel.getBreedInfo(breedName) }
                }
            )

            breedInfo.isNullOrEmpty().IfTrueOrFalse(
                actionIfTrue = {
                    NoSearchCard(modifier)
                },
                actionIfFalse = {
                    LazyColumn(
                        modifier = modifier,
                    ) {
                        items(breedInfo.orEmpty()) { breedInfo ->
                            BreedSearchItem(
                                modifier = modifier,
                                breed = breedInfo,
                                onClickBreed = { navigateToDetailScreen.invoke(breedInfo.id!!) }
                            )

                        }
                    }
                }
            )
        }
        onError?.showTextInSnackbar(scope, snackbarHostState)
    }

}
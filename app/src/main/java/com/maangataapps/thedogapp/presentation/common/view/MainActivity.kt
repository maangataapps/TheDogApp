package com.maangataapps.thedogapp.presentation.common.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maangataapps.thedogapp.infrastructure.utils.BREED_ID
import com.maangataapps.thedogapp.presentation.breedsscreen.view.BreedsScreen
import com.maangataapps.thedogapp.presentation.breedsscreen.viewmodel.BreedsViewmodel
import com.maangataapps.thedogapp.presentation.common.view.ui.theme.TheDogAppTheme
import com.maangataapps.thedogapp.presentation.detailsscreen.view.DetailsScreen
import com.maangataapps.thedogapp.presentation.detailsscreen.viewmodel.DetailsViewmodel
import com.maangataapps.thedogapp.presentation.searchscreen.view.SearchScreen
import com.maangataapps.thedogapp.presentation.searchscreen.viewmodel.SearchViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheDogAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = AppScreens.BreedScreenNav.route) {
                        composable(AppScreens.BreedScreenNav.route) {
                            val breedsViewModel = hiltViewModel<BreedsViewmodel>()
                            BreedsScreen(
                                viewModel = breedsViewModel,
                                navigateToBreedsScreen = { navController.navigate(AppScreens.BreedScreenNav.route) },
                                navigateToSearchScreen = { navController.navigate(AppScreens.SearchScreenNav.route) },
                                navigateToDetailScreen = { breedId -> navController.navigate(AppScreens.DetailsScreenNav.createRoute(breedId)) },
                            )
                        }
                        composable(AppScreens.SearchScreenNav.route) {
                            val searchViewModel = hiltViewModel<SearchViewmodel>()
                            SearchScreen(
                                viewModel = searchViewModel,
                                navigateToBreedsScreen = { navController.navigate(AppScreens.BreedScreenNav.route) },
                                navigateToSearchScreen = { navController.navigate(AppScreens.SearchScreenNav.route) },
                                navigateToDetailScreen = { breedId -> navController.navigate(AppScreens.DetailsScreenNav.createRoute(breedId)) },
                            )
                        }
                        composable(
                            AppScreens.DetailsScreenNav.route,
                            arguments = listOf(navArgument(BREED_ID) { type = NavType.IntType })
                        ) { backStackEntry ->
                            val detailsViewmodel = hiltViewModel<DetailsViewmodel>()
                            val breedId = backStackEntry.arguments?.getInt(BREED_ID)
                            requireNotNull(breedId) { "breedId parameter wasn't found. Please make sure it's set!" }
                            DetailsScreen(
                                detailsViewmodel = detailsViewmodel,
                                breedId = breedId
                            )
                        }
                    }
                }
            }
        }
    }

}
package com.maangataapps.thedogapp.presentation.common.view

import com.maangataapps.thedogapp.infrastructure.utils.BREED
import com.maangataapps.thedogapp.infrastructure.utils.BREED_ID
import com.maangataapps.thedogapp.infrastructure.utils.DETAILS
import com.maangataapps.thedogapp.infrastructure.utils.SEARCH

sealed class AppScreens(val route: String) {
    object BreedScreenNav : AppScreens(BREED)
    object SearchScreenNav : AppScreens(SEARCH)
    object DetailsScreenNav : AppScreens("$DETAILS/{$BREED_ID}") {
        fun createRoute(breedId: Int) = "$DETAILS/$breedId"
    }
}
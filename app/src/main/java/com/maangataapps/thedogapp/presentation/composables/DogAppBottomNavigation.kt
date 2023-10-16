package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.presentation.breedsscreen.view.BottomTabButtonType

@Composable
fun DogAppBottomNavigation(
    modifier: Modifier = Modifier,
    routeOrdinal: Int,
    onClickBreeds: () -> Unit,
    onClickSearch: () -> Unit
) {

    NavigationBar(
        modifier = modifier.background(MaterialTheme.colorScheme.surfaceVariant),
    ) {
        NavigationBarItem(
            modifier = modifier,
            selected = routeOrdinal == BottomTabButtonType.Breeds.ordinal,
            onClick = {
                onClickBreeds.invoke()
                      },
            label = {
                Text(
                    modifier = modifier,
                    text = stringResource(id = R.string.breeds),
                )
            },
            icon = {
                Icon(
                    modifier = Modifier.padding(top = Dimens.Padding.ExtraSmall.dp),
                    painter = painterResource(id = R.drawable.footprint),
                    tint = Color.Gray,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            modifier = modifier,
            selected = routeOrdinal == BottomTabButtonType.Search.ordinal,
            onClick = {
                onClickSearch.invoke()
                      },
            label = {
                Text(text = stringResource(id = R.string.search))
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
               )
            },
        )
    }
}
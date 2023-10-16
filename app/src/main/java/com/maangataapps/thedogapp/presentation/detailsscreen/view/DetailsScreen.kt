package com.maangataapps.thedogapp.presentation.detailsscreen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.allFieldsEmpty
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.defaultCardElevation
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.orFillEmptyField
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.showTextInSnackbar
import com.maangataapps.thedogapp.presentation.composables.RedSnackbar
import com.maangataapps.thedogapp.presentation.detailsscreen.viewmodel.DetailsViewmodel

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    detailsViewmodel: DetailsViewmodel,
    breedId: Int,
) {
    val breedDetails by detailsViewmodel.breedDetails.observeAsState()
    val onError by detailsViewmodel.onError.observeAsState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    detailsViewmodel.setBreedId(breedId)

    Scaffold(
        modifier= modifier.fillMaxWidth(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackBarData ->
                RedSnackbar(modifier = modifier, snackbarData = snackBarData)
            }
        },
    ) { paddingValues ->
        Card(
            modifier = modifier
                .padding(paddingValues)
                .padding(Dimens.Padding.Normal.dp),
            elevation = CardDefaults.defaultCardElevation(),
            shape = RoundedCornerShape(Dimens.Roundness.Normal.dp),
        ) {
            Column(
                modifier = modifier
                    .padding(Dimens.Padding.Normal.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.Normal.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                if (breedDetails.allFieldsEmpty()) {
                    Text(
                        modifier = modifier.padding(
                            start = Dimens.Padding.Normal.dp,
                            end = Dimens.Padding.Normal.dp,
                            top = Dimens.Padding.Normal.dp,
                        ),
                        text = stringResource(id = R.string.breed_not_found),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Text(
                        modifier = modifier.padding(
                            start = Dimens.Padding.Normal.dp,
                            end = Dimens.Padding.Normal.dp,
                            top = Dimens.Padding.Normal.dp,
                        ),
                        text = breedDetails?.name.orEmpty(),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = modifier.padding(
                            horizontal = Dimens.Padding.Normal.dp,
                        ),
                        text = breedDetails?.category.orFillEmptyField(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = modifier.padding(
                            horizontal = Dimens.Padding.Normal.dp,
                        ),
                        text = breedDetails?.origin.orFillEmptyField(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = modifier.padding(
                            horizontal = Dimens.Padding.Normal.dp,
                        ),
                        text = breedDetails?.temperament.orFillEmptyField(),
                        textAlign = TextAlign.Start
                    )
                    onError?.showTextInSnackbar(scope, snackbarHostState)
                }
            }
        }
    }

}
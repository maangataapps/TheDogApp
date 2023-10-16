package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.maangataapps.thedogapp.R
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.defaultCardElevation
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun BreedListItem(
    modifier: Modifier,
    breed: Breed,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .padding(horizontal = Dimens.Padding.Extra.dp)
            .clickable { onClick(breed.id) },
        elevation = CardDefaults.defaultCardElevation(),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                modifier = modifier.size(100.dp, 100.dp),
                imageModel = { breed.image.url },
                component = rememberImageComponent {
                    +ShimmerPlugin(
                        width = 200.dp,
                        baseColor = MaterialTheme.colorScheme.tertiary,
                        highlightColor = MaterialTheme.colorScheme.tertiaryContainer,
                        tilt = 1f,
                        intensity = 1f,
                    )
                },
                requestOptions = {
                    RequestOptions()
                        .placeholder(R.drawable.footprint)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                ),
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.Padding.Extra.dp),
                text = breed.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}
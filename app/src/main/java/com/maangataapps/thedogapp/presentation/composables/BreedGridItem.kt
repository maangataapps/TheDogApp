package com.maangataapps.thedogapp.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Dimens
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.defaultCardElevation
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun BreedGridItem(
    modifier: Modifier,
    breed: Breed,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .padding(top = Dimens.Padding.Normal.dp),
        elevation = CardDefaults.defaultCardElevation(),
        shape = RoundedCornerShape(Dimens.Roundness.Normal.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick.invoke(breed.id) },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GlideImage(
                modifier = modifier
                    .padding(top = Dimens.Padding.Normal.dp)
                    .clip(CircleShape),
                imageModel = { breed.image.url },
                component = rememberImageComponent {
                    +ShimmerPlugin(
                        width = 200.dp,
                        baseColor = MaterialTheme.colorScheme.tertiary,
                        highlightColor = Color.White,
                        tilt = 1f,
                        intensity = 1f,
                    )
                },
                requestOptions = {
                    RequestOptions()
                        .override(200, 200)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                )
            )
            Text(
                modifier = Modifier.paddingFromBaseline(top = Dimens.Padding.Large.dp, bottom = Dimens.Padding.Small.dp),
                text = breed.name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}
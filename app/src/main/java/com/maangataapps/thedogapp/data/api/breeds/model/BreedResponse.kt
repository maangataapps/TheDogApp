package com.maangataapps.thedogapp.data.api.breeds.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class BreedResponse(
    @Json(name = "id") val breedId: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: BreedImageResponse,
    @Json(name = "category") val category: String?,
    @Json(name = "origin") val origin: String?,
    @Json(name = "temperament") val temperament: String?,
    @Json(name = "breed_group") val group: String?,
)

@Serializable
data class BreedImageResponse(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String,
)
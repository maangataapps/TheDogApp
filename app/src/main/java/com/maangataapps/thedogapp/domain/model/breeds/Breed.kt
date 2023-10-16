package com.maangataapps.thedogapp.domain.model.breeds

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: BreedImage,
)

@JsonClass(generateAdapter = true)
data class BreedImage(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String,
)
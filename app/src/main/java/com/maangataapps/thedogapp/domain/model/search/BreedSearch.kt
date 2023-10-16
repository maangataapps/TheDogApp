package com.maangataapps.thedogapp.domain.model.search

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedSearch(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "breed_group") val group: String?,
    @Json(name = "origin") val origin: String?,
)
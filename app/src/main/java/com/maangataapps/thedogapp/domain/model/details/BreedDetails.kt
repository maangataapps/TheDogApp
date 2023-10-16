package com.maangataapps.thedogapp.domain.model.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedDetails(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "category") val category: String?,
    @Json(name = "origin") val origin: String?,
    @Json(name = "temperament") val temperament: String?,
)
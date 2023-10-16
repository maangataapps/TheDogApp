package com.maangataapps.thedogapp.infrastructure.utils

import com.maangataapps.thedogapp.data.api.breeds.model.BreedImageResponse
import com.maangataapps.thedogapp.data.api.breeds.model.BreedResponse
import com.maangataapps.thedogapp.data.local.model.breeds.BreedEntity
import com.maangataapps.thedogapp.data.local.model.breeds.BreedsEntity
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.model.breeds.BreedImage
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun List<BreedResponse>.mapToEntity(): BreedsEntity {
    val entitiesList = this.map { breedResponse ->
        val imageResponse = BreedImageResponse(
            id = breedResponse.image.id,
            url = breedResponse.image.url,
        )
        Json.encodeToString(
            BreedEntity(
                breedId = breedResponse.breedId,
                name = breedResponse.name,
                imageId = imageResponse.id,
                imageUrl = imageResponse.url,
                breedResponse.category,
                breedResponse.origin,
                breedResponse.temperament,
                breedResponse.group
            )
        )
    }
    return BreedsEntity(
        data = entitiesList
    )
}

fun BreedsEntity.mapToBreedList(): List<Breed> {
    val breedEntityList = mutableListOf<BreedEntity>()
    this.data.forEach { item ->
        breedEntityList.add(Json.decodeFromString(item))
    }
    return breedEntityList.map { breedEntity ->
        Breed(
            id = breedEntity.breedId,
            name = breedEntity.name,
            image = BreedImage(
                id = breedEntity.imageId,
                url = breedEntity.imageUrl,
            ),
        )
    }
}

fun BreedsEntity.mapToBreedEntityList(): List<BreedEntity> {
    val breedEntityList = mutableListOf<BreedEntity>()
    this.data.forEach { item ->
        breedEntityList.add(Json.decodeFromString(item))
    }
    return breedEntityList
}

fun BreedEntity.mapToBreedSearch(): BreedSearch {
    return BreedSearch(
        id = this.breedId,
        name = this.name,
        group = this.group,
        origin = this.origin,
    )
}

fun BreedEntity.mapToBreedDetails(): BreedDetails {
    return BreedDetails(
        id = this.breedId,
        name = this.name,
        category = this.category,
        origin = this.origin,
        temperament = this.temperament,
    )
}

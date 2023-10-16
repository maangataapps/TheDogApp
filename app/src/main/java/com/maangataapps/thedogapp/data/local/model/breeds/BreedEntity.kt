package com.maangataapps.thedogapp.data.local.model.breeds

import com.maangataapps.thedogapp.infrastructure.utils.ListStringConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable

@Entity
data class BreedsEntity(
    @Id
    var id: Long = 0,
    @Convert(converter = ListStringConverter::class, dbType = String::class)
    val data: List<String>
)

@Serializable
data class BreedEntity(
    val breedId: Int,
    val name: String,
    val imageId: String,
    val imageUrl: String,
    val category: String?,
    val origin: String?,
    val temperament: String?,
    val group: String?,
)

package com.maangataapps.thedogapp.data.local

import com.maangataapps.thedogapp.data.local.model.breeds.BreedsEntity
import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.infrastructure.localstore.ObjectBox
import com.maangataapps.thedogapp.infrastructure.utils.NEW_OBJECT_ID
import com.maangataapps.thedogapp.infrastructure.utils.mapToBreedDetails
import com.maangataapps.thedogapp.infrastructure.utils.mapToBreedEntityList
import com.maangataapps.thedogapp.infrastructure.utils.mapToBreedList
import com.maangataapps.thedogapp.infrastructure.utils.mapToBreedSearch
import java.util.Locale

object LocalStore {

    private val breedsBox = ObjectBox.store.boxFor(BreedsEntity::class.java)
    private val databaseInfoBox = ObjectBox.store.boxFor(DatabaseInfo::class.java)

    fun databaseExistsInDb(): Boolean {
        getDatabaseInfo()?.let {
            return true
        }
        return false
    }

    fun putBreedsResponse(breedEntity: BreedsEntity): Boolean {
        val id = getBreedEntityId() ?: NEW_OBJECT_ID
        return try {
            breedEntity.id = id
            breedsBox.put(breedEntity)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun putDatabaseInfo(databaseInfo: DatabaseInfo): Boolean {
        val id = getDatabaseInfoId() ?: NEW_OBJECT_ID
        return try {
            databaseInfo.id = id
            databaseInfoBox.put(databaseInfo)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun getDatabaseInfo(): DatabaseInfo? {
        return try {
            databaseInfoBox.all.last()
        } catch (ex: Exception) {
            null
        }
    }

    fun getPaginatedBreeds(limit: Int, page: Int): List<Breed> {
        val breedsList = getBreedsList()
        val breedsCount = breedsList.size
        val initialIndex = limit * page
        val finalIndex = if ((initialIndex + limit) >= breedsCount) breedsCount else initialIndex + limit


        return if (initialIndex > breedsCount) {
            listOf()
        } else if (finalIndex <= breedsCount) {
            breedsList.subList(initialIndex, finalIndex)
        } else {
            listOf()
        }
    }

    fun searchStringInBreedNames(breedName: String): List<BreedSearch> {
        val breedsEntity = getBreedsEntity()?.mapToBreedEntityList() ?: return listOf()
        return breedsEntity
            .filter { breedEntity -> breedEntity.name
                .lowercase(Locale.getDefault())
                .contains(breedName.lowercase(Locale.getDefault()))
            }
            .map {breedEntity ->
                breedEntity.mapToBreedSearch()
            }
    }

    fun retrieveBreedDetails(breedId: Int): BreedDetails? {
        val breedsEntity = getBreedsEntity()?.mapToBreedEntityList() ?: return null
        return breedsEntity
            .find { breedEntity -> breedEntity.breedId == breedId }
            ?.mapToBreedDetails()
    }


    private fun getBreedsList(): List<Breed> = getBreedsEntity()?.mapToBreedList().orEmpty()

    private fun getBreedsEntity(): BreedsEntity? {
        return try {
            breedsBox.all.last()
        } catch (ex: Exception) {
            null
        }
    }

    private fun getBreedEntityId(): Long? = getBreedsEntity()?.id

    private fun getDatabaseInfoId(): Long? = getDatabaseInfo()?.id

}
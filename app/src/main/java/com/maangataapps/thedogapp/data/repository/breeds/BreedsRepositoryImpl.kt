package com.maangataapps.thedogapp.data.repository.breeds

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.maangataapps.thedogapp.data.api.breeds.BreedsApi
import com.maangataapps.thedogapp.data.local.LocalStore
import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.repository.breeds.BreedsRepository
import com.maangataapps.thedogapp.infrastructure.utils.LIMIT_HITS
import com.maangataapps.thedogapp.infrastructure.utils.NetworkUtils
import com.maangataapps.thedogapp.infrastructure.utils.mapToEntity
import javax.inject.Inject

class BreedsRepositoryImpl @Inject constructor(
    private val api: BreedsApi,
    private val networkUtils: NetworkUtils,
): BreedsRepository {

    override fun getAllBreedsListAndSaveItToLocal() {
        val response = executeSync(api.getAllBreedsList())

        response.fold(
            ifLeft = { error -> throw error },
            ifRight = { breedsResponse ->
                val breedsEntity = breedsResponse.mapToEntity()
                // If images were not cached, here would be the call to
                // save the images bitmap as a Base64.
                LocalStore.putBreedsResponse(breedsEntity)
                val databaseInfo = DatabaseInfo(
                    isDBCreated = true,
                    dbItemCount = breedsEntity.data.size,
                )
                LocalStore.putDatabaseInfo(databaseInfo)
            }
        )

    }

    override fun getBreedsList(): Pager<Int, Breed> = Pager (
        config = PagingConfig(pageSize = LIMIT_HITS, enablePlaceholders = true),
        pagingSourceFactory = { BreedsPaginatingSource(api, networkUtils) }
    )

}
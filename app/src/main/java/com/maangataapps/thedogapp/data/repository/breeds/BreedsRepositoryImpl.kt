package com.maangataapps.thedogapp.data.repository.breeds

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.maangataapps.thedogapp.data.api.breeds.BreedsApi
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.repository.breeds.BreedsRepository
import com.maangataapps.thedogapp.infrastructure.utils.LIMIT_HITS
import javax.inject.Inject

class BreedsRepositoryImpl @Inject constructor(
    private val api: BreedsApi,
): BreedsRepository {

    override fun getBreedsList(): Pager<Int, Breed> = Pager (
        config = PagingConfig(pageSize = LIMIT_HITS, enablePlaceholders = true),
        pagingSourceFactory = { BreedsPaginatingSource(api) }
    )

}
package com.maangataapps.thedogapp.data.repository.search

import arrow.core.Either
import com.maangataapps.thedogapp.data.api.search.SearchApi
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.domain.repository.search.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: SearchApi,
): SearchRepository {

    override fun getBreedInfo(breedName: String): Either<Throwable, List<BreedSearch>> {
        return executeSync(api.getBreedInfo(breedName))
    }

}
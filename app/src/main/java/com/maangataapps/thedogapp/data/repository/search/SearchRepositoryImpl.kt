package com.maangataapps.thedogapp.data.repository.search

import arrow.core.Either
import com.maangataapps.thedogapp.data.api.search.SearchApi
import com.maangataapps.thedogapp.data.local.LocalStore
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.domain.repository.search.SearchRepository
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.checkConnectionAndDo
import com.maangataapps.thedogapp.infrastructure.utils.NetworkUtils
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: SearchApi,
    private val networkUtils: NetworkUtils
): SearchRepository {

    override fun getBreedInfo(breedName: String): Either<Throwable, List<BreedSearch>> {
        return networkUtils.checkConnectionAndDo(
            connected = { executeSync(api.getBreedInfo(breedName)) },
            disconnected = {
                execute { LocalStore.searchStringInBreedNames(breedName) }
            }
        )
    }

}
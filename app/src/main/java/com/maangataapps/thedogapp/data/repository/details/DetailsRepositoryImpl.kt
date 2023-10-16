package com.maangataapps.thedogapp.data.repository.details

import arrow.core.Either
import com.maangataapps.thedogapp.data.api.details.DetailsApi
import com.maangataapps.thedogapp.data.local.LocalStore
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.repository.details.DetailsRepository
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.checkConnectionAndDo
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.orEmpty
import com.maangataapps.thedogapp.infrastructure.utils.NetworkUtils
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val api: DetailsApi,
    private val networkUtils: NetworkUtils,
) : DetailsRepository {

    override fun getBreedDetails(breedId: Int): Either<Throwable, BreedDetails> {
        return networkUtils.checkConnectionAndDo(
            connected = {
                executeSync(api.getBreedDetails(breedId))
            },
            disconnected = {
                execute { LocalStore.retrieveBreedDetails(breedId).orEmpty() }
            }
        )
    }
}
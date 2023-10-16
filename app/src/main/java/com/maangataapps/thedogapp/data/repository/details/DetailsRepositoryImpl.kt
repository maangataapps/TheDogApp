package com.maangataapps.thedogapp.data.repository.details

import arrow.core.Either
import com.maangataapps.thedogapp.data.api.details.DetailsApi
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.repository.details.DetailsRepository
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val api: DetailsApi,
) : DetailsRepository {

    override fun getBreedDetails(breedId: Int): Either<Throwable, BreedDetails> {
        return executeSync(api.getBreedDetails(breedId))
    }
}
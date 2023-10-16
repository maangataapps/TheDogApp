package com.maangataapps.thedogapp.domain.repository.details

import arrow.core.Either
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.repository.RetrofitRepository

interface DetailsRepository: RetrofitRepository {
    fun getBreedDetails(breedId: Int): Either<Throwable, BreedDetails>
}
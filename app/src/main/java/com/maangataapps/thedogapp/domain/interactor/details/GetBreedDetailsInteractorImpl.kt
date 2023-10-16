package com.maangataapps.thedogapp.domain.interactor.details

import arrow.core.Either
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.domain.repository.details.DetailsRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class GetBreedDetailsInteractorImpl @Inject constructor(
    private val repository: DetailsRepository
): GetBreedDetailsInteractor {
    override fun executeAsync(breedId: Int): Deferred<Either<Throwable, BreedDetails>> = GlobalScope.async(Dispatchers.IO) {
            repository.getBreedDetails(breedId)
        }
}
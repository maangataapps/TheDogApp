package com.maangataapps.thedogapp.domain.interactor.details

import arrow.core.Either
import com.maangataapps.thedogapp.domain.interactor.Interactor
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import kotlinx.coroutines.Deferred

interface GetBreedDetailsInteractor: Interactor<BreedDetails> {
    fun executeAsync(breedId: Int): Deferred<Either<Throwable, BreedDetails>>
}
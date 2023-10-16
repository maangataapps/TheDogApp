package com.maangataapps.thedogapp.domain.interactor.search

import arrow.core.Either
import com.maangataapps.thedogapp.domain.interactor.Interactor
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import kotlinx.coroutines.Deferred

interface GetBreedInfoInteractor: Interactor<BreedSearch> {
    fun executeAsync(breedName: String): Deferred<Either<Throwable, List<BreedSearch>>>
}
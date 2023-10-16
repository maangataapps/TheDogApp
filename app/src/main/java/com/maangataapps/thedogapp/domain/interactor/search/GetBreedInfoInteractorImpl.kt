@file:OptIn(DelicateCoroutinesApi::class)

package com.maangataapps.thedogapp.domain.interactor.search

import arrow.core.Either
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.domain.repository.search.SearchRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class GetBreedInfoInteractorImpl @Inject constructor(
    private val repository: SearchRepository
): GetBreedInfoInteractor {
    override fun executeAsync(breedName: String): Deferred<Either<Throwable, List<BreedSearch>>> = GlobalScope.async(Dispatchers.IO) {
        repository.getBreedInfo(breedName)
    }

}
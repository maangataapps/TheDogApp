package com.maangataapps.thedogapp.domain.repository.search

import arrow.core.Either
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.domain.repository.RetrofitRepository

interface SearchRepository: RetrofitRepository {
    fun getBreedInfo(breedName: String): Either<Throwable, List<BreedSearch>>
}
package com.maangataapps.thedogapp.domain.interactor.breeds

import androidx.paging.Pager
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.repository.breeds.BreedsRepository
import javax.inject.Inject

class GetBreedsListInteractorImpl @Inject constructor(
    private val repository: BreedsRepository
): GetBreedsListInteractor {
    override fun executeAsync(): Pager<Int, Breed> {
        return repository.getBreedsList()
    }

}
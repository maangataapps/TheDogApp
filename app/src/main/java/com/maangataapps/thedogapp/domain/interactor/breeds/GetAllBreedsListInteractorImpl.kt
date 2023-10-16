package com.maangataapps.thedogapp.domain.interactor.breeds

import com.maangataapps.thedogapp.domain.repository.breeds.BreedsRepository
import javax.inject.Inject

class GetAllBreedsListInteractorImpl @Inject constructor(
    private val repository: BreedsRepository
): GetAllBreedsListInteractor {
    override fun execute() = repository.getAllBreedsListAndSaveItToLocal()
}
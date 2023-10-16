package com.maangataapps.thedogapp.domain.interactor.breeds

import com.maangataapps.thedogapp.domain.interactor.Interactor
import com.maangataapps.thedogapp.domain.model.breeds.Breed

interface GetAllBreedsListInteractor: Interactor<List<Breed>> {
    fun execute()
}
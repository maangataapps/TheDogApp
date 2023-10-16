package com.maangataapps.thedogapp.domain.interactor.breeds

import androidx.paging.Pager
import com.maangataapps.thedogapp.domain.interactor.Interactor
import com.maangataapps.thedogapp.domain.model.breeds.Breed

interface GetBreedsListInteractor: Interactor<List<Breed>> {
    fun executeAsync(): Pager<Int, Breed>
}
package com.maangataapps.thedogapp.presentation.breedsscreen.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.maangataapps.thedogapp.domain.interactor.breeds.GetBreedsListInteractor
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.presentation.common.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BreedsViewmodel @Inject constructor(
    private val getBreedsListInteractor: GetBreedsListInteractor,
): BaseViewmodel() {

    val breedsList: Flow<PagingData<Breed>>

    init {
        breedsList = getBreedList()
    }

    private fun getBreedList() = getBreedsListInteractor.executeAsync().flow.cachedIn(viewModelScope)

}
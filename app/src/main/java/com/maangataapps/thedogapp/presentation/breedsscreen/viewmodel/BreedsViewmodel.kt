@file:OptIn(DelicateCoroutinesApi::class)

package com.maangataapps.thedogapp.presentation.breedsscreen.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.maangataapps.thedogapp.domain.interactor.database.CheckDatabaseExistenceInteractor
import com.maangataapps.thedogapp.domain.interactor.breeds.GetAllBreedsListInteractor
import com.maangataapps.thedogapp.domain.interactor.breeds.GetBreedsListInteractor
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.Extensions.ifFalse
import com.maangataapps.thedogapp.presentation.common.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BreedsViewmodel @Inject constructor(
    private val getBreedsListInteractor: GetBreedsListInteractor,
    private val getAllBreedsListInteractor: GetAllBreedsListInteractor,
    private val checkDatabaseExistenceInteractor: CheckDatabaseExistenceInteractor,
): BaseViewmodel() {

    val breedsList: Flow<PagingData<Breed>>

    init {
        breedsList = getBreedList()
        checkDatabaseExistence().ifFalse { downloadBreedsInfo() }
    }

    private fun getBreedList() = getBreedsListInteractor.executeAsync().flow.cachedIn(viewModelScope)

    private fun checkDatabaseExistence(): Boolean = checkDatabaseExistenceInteractor.execute()

    private fun downloadBreedsInfo() {
        GlobalScope.launch(Dispatchers.IO) {
            getAllBreedsListInteractor.execute()
        }
    }

}
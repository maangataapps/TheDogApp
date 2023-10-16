package com.maangataapps.thedogapp.presentation.searchscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maangataapps.thedogapp.domain.interactor.search.GetBreedInfoInteractor
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.presentation.common.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewmodel @Inject constructor(
    private val getBreedInfoInteractor: GetBreedInfoInteractor
): BaseViewmodel() {

    private val _breedInfo = MutableLiveData<List<BreedSearch>>()
    val breedInfo: LiveData<List<BreedSearch>>
        get() = _breedInfo

    fun getBreedInfo(breedName: String) {
        launch(
            success = ::onGetBreedInfoSuccess,
            error = ::onGetBreedInfoError,
        ) {
            getBreedInfoInteractor.executeAsync(breedName).await()
        }
    }

    private fun onGetBreedInfoSuccess(breedSearch: List<BreedSearch>) {
        _breedInfo.value = breedSearch
    }

    private fun onGetBreedInfoError(error: Throwable) = setErrorMessage(error.message.orEmpty())

}
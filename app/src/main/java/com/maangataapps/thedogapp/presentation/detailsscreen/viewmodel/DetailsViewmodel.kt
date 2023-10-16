package com.maangataapps.thedogapp.presentation.detailsscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maangataapps.thedogapp.domain.interactor.details.GetBreedDetailsInteractor
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.presentation.common.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewmodel @Inject constructor(
    private val getBreedDetailsInteractor: GetBreedDetailsInteractor
) : BaseViewmodel() {

    private val _breedDetails = MutableLiveData<BreedDetails>()
    val breedDetails: LiveData<BreedDetails>
        get() = _breedDetails

    private var gotBreedDetails: Boolean = false

    fun setBreedId(breedId: Int) {
        if (!gotBreedDetails) {
            gotBreedDetails = true
            getBreedDetails(breedId)
        }
    }

    private fun getBreedDetails(breedId: Int) {
        launch(
            success = ::onGetBreedDetailsSuccess,
            error = ::onGetBreedDetailsError,
        ) {
            getBreedDetailsInteractor.executeAsync(breedId).await()
        }
    }

    private fun onGetBreedDetailsSuccess(breedDetails: BreedDetails) {
        _breedDetails.value = breedDetails
    }

    private fun onGetBreedDetailsError(error: Throwable) = setErrorMessage(error.message.orEmpty())

}
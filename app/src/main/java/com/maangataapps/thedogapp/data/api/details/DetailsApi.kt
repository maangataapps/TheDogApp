package com.maangataapps.thedogapp.data.api.details

import com.maangataapps.thedogapp.BuildConfig
import com.maangataapps.thedogapp.domain.model.details.BreedDetails
import com.maangataapps.thedogapp.infrastructure.utils.BREEDS
import com.maangataapps.thedogapp.infrastructure.utils.BREED_ID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("${BuildConfig.BASE_URL}$BREEDS/{breedId}")
    fun getBreedDetails(@Path(BREED_ID) breedId: Int): Call<BreedDetails>
}
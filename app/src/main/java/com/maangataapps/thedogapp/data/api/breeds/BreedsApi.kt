package com.maangataapps.thedogapp.data.api.breeds

import com.maangataapps.thedogapp.BuildConfig
import com.maangataapps.thedogapp.data.api.breeds.model.BreedResponse
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.infrastructure.utils.BREEDS
import com.maangataapps.thedogapp.infrastructure.utils.LIMIT
import com.maangataapps.thedogapp.infrastructure.utils.PAGE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedsApi {
    @GET("${BuildConfig.BASE_URL}$BREEDS")
    fun getBreedsList(@Query(LIMIT) limit: Int, @Query(PAGE) page: Int): Call<List<Breed>>

    @GET("${BuildConfig.BASE_URL}$BREEDS")
    fun getAllBreedsList(): Call<List<BreedResponse>>
}
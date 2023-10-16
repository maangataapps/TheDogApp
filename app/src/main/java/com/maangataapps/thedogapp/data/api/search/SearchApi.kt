package com.maangataapps.thedogapp.data.api.search

import com.maangataapps.thedogapp.BuildConfig
import com.maangataapps.thedogapp.domain.model.search.BreedSearch
import com.maangataapps.thedogapp.infrastructure.utils.BREEDS
import com.maangataapps.thedogapp.infrastructure.utils.QUERY_FOR_BREEDS
import com.maangataapps.thedogapp.infrastructure.utils.SEARCH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("${BuildConfig.BASE_URL}$BREEDS/$SEARCH")
    fun getBreedInfo(@Query(QUERY_FOR_BREEDS) breedName: String): Call<List<BreedSearch>>
}
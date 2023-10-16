package com.maangataapps.thedogapp.infrastructure.di

import com.maangataapps.thedogapp.BuildConfig
import com.maangataapps.thedogapp.data.api.breeds.BreedsApi
import com.maangataapps.thedogapp.data.api.details.DetailsApi
import com.maangataapps.thedogapp.data.api.search.SearchApi
import com.maangataapps.thedogapp.infrastructure.utils.getOkHttpClientBuilder
import com.maangataapps.thedogapp.infrastructure.utils.getRetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    fun providesBaseUrl(): String = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun providesOkHttpClient() = getOkHttpClientBuilder()

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit = getRetrofitBuilder().build()

    @Singleton
    @Provides
    fun providesBreedsApi(retrofit: Retrofit): BreedsApi = retrofit.create(BreedsApi::class.java)

}
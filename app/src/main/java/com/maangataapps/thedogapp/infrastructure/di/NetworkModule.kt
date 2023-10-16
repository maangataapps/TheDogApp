package com.maangataapps.thedogapp.infrastructure.di

import android.content.Context
import com.maangataapps.thedogapp.infrastructure.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesNetworkUtils(@ApplicationContext context: Context): NetworkUtils = NetworkUtils(context)
}
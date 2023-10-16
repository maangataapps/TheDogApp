package com.maangataapps.thedogapp.infrastructure.di

import com.maangataapps.thedogapp.data.repository.details.DetailsRepositoryImpl
import com.maangataapps.thedogapp.domain.interactor.details.GetBreedDetailsInteractor
import com.maangataapps.thedogapp.domain.interactor.details.GetBreedDetailsInteractorImpl
import com.maangataapps.thedogapp.domain.repository.details.DetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DetailsModule {

    @Singleton
    @Binds
    abstract fun bindsGetBreedDetailsInteractor(interactor: GetBreedDetailsInteractorImpl): GetBreedDetailsInteractor

    @Singleton
    @Binds
    abstract fun bindsDetailsRepository(repository: DetailsRepositoryImpl): DetailsRepository
}
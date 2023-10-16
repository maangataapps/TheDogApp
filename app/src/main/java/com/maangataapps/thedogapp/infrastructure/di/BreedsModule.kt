package com.maangataapps.thedogapp.infrastructure.di

import com.maangataapps.thedogapp.data.repository.breeds.BreedsRepositoryImpl
import com.maangataapps.thedogapp.domain.interactor.breeds.GetAllBreedsListInteractor
import com.maangataapps.thedogapp.domain.interactor.breeds.GetAllBreedsListInteractorImpl
import com.maangataapps.thedogapp.domain.interactor.breeds.GetBreedsListInteractor
import com.maangataapps.thedogapp.domain.interactor.breeds.GetBreedsListInteractorImpl
import com.maangataapps.thedogapp.domain.repository.breeds.BreedsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class BreedsModule {

    @Singleton
    @Binds
    abstract fun bindsGetBreedsListInteractor(interactor: GetBreedsListInteractorImpl): GetBreedsListInteractor

    @Singleton
    @Binds
    abstract fun bindsBreedsRepository(repository: BreedsRepositoryImpl): BreedsRepository

    @Singleton
    @Binds
    abstract fun bindsGetAllBreedsInteractor(interactor: GetAllBreedsListInteractorImpl): GetAllBreedsListInteractor

}
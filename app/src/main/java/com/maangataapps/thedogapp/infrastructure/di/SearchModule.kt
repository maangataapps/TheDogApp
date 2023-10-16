package com.maangataapps.thedogapp.infrastructure.di

import com.maangataapps.thedogapp.data.repository.search.SearchRepositoryImpl
import com.maangataapps.thedogapp.domain.interactor.search.GetBreedInfoInteractor
import com.maangataapps.thedogapp.domain.interactor.search.GetBreedInfoInteractorImpl
import com.maangataapps.thedogapp.domain.repository.search.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class SearchModule {

    @Singleton
    @Binds
    abstract fun bindsGetBreedInfoInteractor(interactor: GetBreedInfoInteractorImpl): GetBreedInfoInteractor

    @Singleton
    @Binds
    abstract fun bindsSearchRepository(repository: SearchRepositoryImpl): SearchRepository

}
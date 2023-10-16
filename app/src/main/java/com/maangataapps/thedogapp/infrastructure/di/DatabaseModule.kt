package com.maangataapps.thedogapp.infrastructure.di

import com.maangataapps.thedogapp.data.repository.database.DatabaseRepositoryImpl
import com.maangataapps.thedogapp.domain.interactor.database.CheckDatabaseExistenceInteractor
import com.maangataapps.thedogapp.domain.interactor.database.CheckDatabaseExistenceInteractorImpl
import com.maangataapps.thedogapp.domain.repository.database.DatabaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModule {

    @Singleton
    @Binds
    abstract fun bindsCheckDatabaseExistenceInteractor(interactor: CheckDatabaseExistenceInteractorImpl): CheckDatabaseExistenceInteractor

    @Singleton
    @Binds
    abstract fun bindsDatabaseRepository(interactor: DatabaseRepositoryImpl): DatabaseRepository

}
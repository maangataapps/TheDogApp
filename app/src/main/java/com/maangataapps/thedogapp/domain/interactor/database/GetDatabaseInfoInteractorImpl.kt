package com.maangataapps.thedogapp.domain.interactor.database

import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo
import com.maangataapps.thedogapp.domain.repository.database.DatabaseRepository
import javax.inject.Inject

class GetDatabaseInfoInteractorImpl @Inject constructor(
    private val repository: DatabaseRepository
): GetDatabaseInfoInteractor {
    override fun executeAsync(): DatabaseInfo? = repository.getDatabaseInfo()
}
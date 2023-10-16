package com.maangataapps.thedogapp.domain.interactor.database

import com.maangataapps.thedogapp.domain.repository.database.DatabaseRepository
import javax.inject.Inject

class CheckDatabaseExistenceInteractorImpl @Inject constructor(
    private val repository: DatabaseRepository
): CheckDatabaseExistenceInteractor {
    override fun execute(): Boolean = repository.checkDatabaseExistence()
}
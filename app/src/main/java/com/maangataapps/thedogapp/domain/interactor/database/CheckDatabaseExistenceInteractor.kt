package com.maangataapps.thedogapp.domain.interactor.database

import com.maangataapps.thedogapp.domain.interactor.Interactor

interface CheckDatabaseExistenceInteractor: Interactor<Boolean> {
    fun execute(): Boolean
}
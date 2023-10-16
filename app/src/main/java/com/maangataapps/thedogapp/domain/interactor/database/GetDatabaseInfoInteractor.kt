package com.maangataapps.thedogapp.domain.interactor.database

import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo
import com.maangataapps.thedogapp.domain.interactor.Interactor

interface GetDatabaseInfoInteractor: Interactor<DatabaseInfo> {
    fun executeAsync(): DatabaseInfo?
}
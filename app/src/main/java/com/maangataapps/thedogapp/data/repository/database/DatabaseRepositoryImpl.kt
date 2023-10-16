package com.maangataapps.thedogapp.data.repository.database

import com.maangataapps.thedogapp.data.local.LocalStore
import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo
import com.maangataapps.thedogapp.domain.repository.database.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(): DatabaseRepository {

    override fun getDatabaseInfo(): DatabaseInfo? {
        try {
            return LocalStore.getDatabaseInfo()
        } catch (error: Throwable) {
            throw error
        }
    }

    override fun checkDatabaseExistence(): Boolean {
        return LocalStore.databaseExistsInDb()
    }
}
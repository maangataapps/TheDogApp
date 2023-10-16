package com.maangataapps.thedogapp.domain.repository.database

import com.maangataapps.thedogapp.data.local.model.database.DatabaseInfo

interface DatabaseRepository {
    fun getDatabaseInfo(): DatabaseInfo?
    fun checkDatabaseExistence(): Boolean
}
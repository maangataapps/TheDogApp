package com.maangataapps.thedogapp.data.local.model.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class DatabaseInfo(
    @Id
    var id: Long = 0,
    val isDBCreated: Boolean,
    val dbItemCount: Int,
)
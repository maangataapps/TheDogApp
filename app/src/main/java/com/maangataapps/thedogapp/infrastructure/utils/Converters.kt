package com.maangataapps.thedogapp.infrastructure.utils

import io.objectbox.converter.PropertyConverter

class ListStringConverter : PropertyConverter<List<String>?, String?> {
    override fun convertToEntityProperty(databaseValue: String?): List<String>? {
        if (databaseValue.isNullOrEmpty()) {
            return null
        }
        return databaseValue.split(SEPARATOR)
    }

    override fun convertToDatabaseValue(entityProperty: List<String>?): String? {
        return entityProperty?.joinToString(SEPARATOR)
    }
}
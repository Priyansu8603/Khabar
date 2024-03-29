package com.example.khabarapplication.Database

import androidx.room.TypeConverter
import com.example.khabarapplication.Models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String?): Source {
        return Source(id = name.orEmpty(), name = name.orEmpty())
    }

}
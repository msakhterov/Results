package ru.msakhterov.results.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "activities")
data class Activity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    var name: String
    )

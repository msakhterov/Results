package ru.msakhterov.results.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "activities")
data class Activity (
    @PrimaryKey(autoGenerate = true) var id: Int?,
    var name: String,
    var unit: String
) {



}
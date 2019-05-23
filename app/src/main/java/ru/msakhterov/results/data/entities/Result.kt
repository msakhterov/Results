package ru.msakhterov.results.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "results",
    foreignKeys = arrayOf(ForeignKey(
        entity = Activity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("activity_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
        )))
class Result (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "activity_id") var activityId: Int,
    val value: Float
    )
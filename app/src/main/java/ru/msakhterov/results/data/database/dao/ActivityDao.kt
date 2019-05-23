package ru.msakhterov.results.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.msakhterov.results.data.entities.Activity

@Dao
interface ActivityDao {

    @get:Query("SELECT * FROM activities")
    val activitiesList: LiveData<List<Activity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivity(activity: Activity)

    @Query("SELECT * FROM activities WHERE id = :id")
    fun getActivity(id: Int): LiveData<Activity>

    @Update
    fun updateActivity(activity: Activity)

    @Delete
    fun deleteActivity(activity: Activity)

}

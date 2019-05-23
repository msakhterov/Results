package ru.msakhterov.results.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.data.entities.Result

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(result: Result)

    @Query("SELECT * FROM results WHERE id = :id")
    fun getResult(id: Int): LiveData<Result>

    @Query("SELECT * FROM results WHERE activity_id = :activityId")
    fun getResultsByActivity(activityId: Int): LiveData<Result>

    @Update
    fun updateResult(result: Result)

    @Delete
    fun deleteResult(result: Result)

}

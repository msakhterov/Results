package ru.msakhterov.results.data.repositories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import ru.msakhterov.results.data.database.dao.ActivityDao
import ru.msakhterov.results.data.entities.Activity

class ActivityRepository(private val activityDao: ActivityDao) {

    val activitiesList: LiveData<List<Activity>> = activityDao.activitiesList

    @WorkerThread
    fun getActivity(id: Int): LiveData<Activity> = activityDao.getActivity(id)

    @WorkerThread
    fun insertActivity(activity: Activity) {
        activityDao.insertActivity(activity)
    }

    @WorkerThread
    fun updateActivity(activity: Activity) {
        activityDao.updateActivity(activity)
    }

    @WorkerThread
    fun deleteActivity(activity: Activity) {
        activityDao.deleteActivity(activity)
    }


}
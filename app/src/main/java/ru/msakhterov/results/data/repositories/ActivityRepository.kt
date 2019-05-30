package ru.msakhterov.results.data.repositories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import ru.msakhterov.results.data.database.dao.ActivityDao
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.utils.ioThread

class ActivityRepository(private val activityDao: ActivityDao) {

    val activitiesList: LiveData<List<Activity>> = activityDao.activitiesList

    @WorkerThread
    fun getActivity(id: Int): LiveData<Activity> = activityDao.getActivity(id)

    @WorkerThread
    fun insertActivity(activity: Activity) = ioThread {
        activityDao.insertActivity(activity)
    }

    @WorkerThread
    fun updateActivity(activity: Activity) = ioThread {
        activityDao.updateActivity(activity)
    }

    @WorkerThread
    fun deleteActivity(activity: Activity) = ioThread {
        activityDao.deleteActivity(activity)
    }


}
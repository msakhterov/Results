package ru.msakhterov.results.ui.view_models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import ru.msakhterov.results.data.database.ResultsDatabase
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.data.repositories.ActivityRepository
import ru.msakhterov.results.ui.view_states.ActivityViewState

class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ActivityRepository
    private val activityViewStateLiveData: MutableLiveData<ActivityViewState> = MutableLiveData()

    init {
        val activityDao = ResultsDatabase.getDatabase(application).activityDao
        repository = ActivityRepository(activityDao)
        repository.activitiesList.observeForever{
            activityViewStateLiveData.value = activityViewStateLiveData.value?.copy(activities = it!!)
                ?: ActivityViewState(it!!)
        }
    }

    fun viewState(): LiveData<ActivityViewState> = activityViewStateLiveData

    fun addActivity(activity: Activity) = repository.insertActivity(activity)

    fun updateActivity(activity: Activity) = repository.updateActivity(activity)

    fun deleteActivity(activity: Activity) = repository.deleteActivity(activity)




}
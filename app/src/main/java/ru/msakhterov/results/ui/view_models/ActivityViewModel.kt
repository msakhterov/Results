package ru.msakhterov.results.ui.view_models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import ru.msakhterov.results.data.database.ResultsDatabase
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.data.repositories.ActivityRepository

class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ActivityRepository
    val activityLiveData: LiveData<List<Activity>>

    init {
        val activityDao = ResultsDatabase.getDatabase(application).activityDao
        repository = ActivityRepository(activityDao)
        activityLiveData = repository.activitiesList
    }

    


}
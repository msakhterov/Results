package ru.msakhterov.results.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_activities.*
import ru.msakhterov.results.R
import ru.msakhterov.results.Utils.Constants
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.ui.adapters.ActivitiesRVAdapter
import ru.msakhterov.results.ui.view_models.ActivityViewModel
import timber.log.Timber


class ActivitiesFragment: Fragment() {

    lateinit var viewModel: ActivityViewModel
    lateinit var adapter: ActivitiesRVAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activities, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)

        recycler_view.layoutManager = LinearLayoutManager(this.activity)
        adapter = ActivitiesRVAdapter(

        )
        recycler_view.adapter = adapter

        viewModel.viewState().observe(this, Observer { viewState ->
            viewState?.let { adapter.activities = viewState.activities }
        })

        fragment_fab.setOnClickListener{
            openCreateActivityDialog()
        }
    }

    fun openCreateActivityDialog(): Unit {
        val fragment = CreateActivityDialogFragment()
        fragment.setTargetFragment(this, Constants.CREATE_REQUEST)
        fragmentManager?.let {fragment.show(it, fragment.javaClass.name)  }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == android.app.Activity.RESULT_OK){
            when(requestCode) {
                Constants.CREATE_REQUEST -> {
                    data?.let{
                        if (data.getIntExtra(CreateActivityDialogFragment.TAG_RESULT_CREATE, -1) == Constants.RESULT_OK){
                            createActivity(Activity(null, data.getStringExtra(CreateActivityDialogFragment.TAG_RESULT_TITLE),
                                data.getStringExtra(CreateActivityDialogFragment.TAG_RESULT_UNITS)))
                        }
                    }
                }
            }
        }
    }

    fun createActivity(activity: Activity) = viewModel.addActivity(activity)

    fun editActivity(activity: Activity) = viewModel.updateActivity(activity)

    fun deleteActivity(activity: Activity) = viewModel.deleteActivity(activity)
}
package ru.msakhterov.results.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_activities.*
import ru.msakhterov.results.R
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
        adapter = ActivitiesRVAdapter()
        recycler_view.adapter = adapter

        viewModel.activityLiveData.observe(this, Observer { activities ->
            activities?.let { adapter.activities = activities }
        })

        fragment_fab.setOnClickListener{
            Timber.d("OnClick")
        }
    }
}
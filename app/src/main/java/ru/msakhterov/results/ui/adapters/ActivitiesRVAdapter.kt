package ru.msakhterov.results.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_activity.view.*
import ru.msakhterov.results.R
import ru.msakhterov.results.data.entities.Activity

class ActivitiesRVAdapter() : RecyclerView.Adapter<ActivitiesRVAdapter.ViewHolder>() {

    var activities: List<Activity> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_activity,
                parent,
                false
            )
        )

    override fun getItemCount() = activities.size

    override fun onBindViewHolder(vh: ViewHolder, pos: Int) = vh.bind(activities[pos])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(activity: Activity) = with(itemView) {
            tv_activity_title.text = activity.name
        }
    }
}
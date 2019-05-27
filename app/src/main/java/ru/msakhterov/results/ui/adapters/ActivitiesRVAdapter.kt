package ru.msakhterov.results.ui.adapters

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_activity.view.*
import ru.msakhterov.results.R
import ru.msakhterov.results.data.entities.Activity

class ActivitiesRVAdapter(
    val onItemClick: ((Activity) -> Unit)? = null,
    val onEditClick: ((Activity) -> Unit)? = null,
    val onDeleteClick: ((Activity) -> Unit)? = null
) : RecyclerView.Adapter<ActivitiesRVAdapter.ViewHolder>() {

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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(activity: Activity) = with(itemView) {
            setOnClickListener{
                onItemClick?.invoke(activity)
            }

            tv_activity_title.text = activity.name
            ib_more.setOnClickListener{
                val popupMenu = PopupMenu(context, it)
                popupMenu.inflate(R.menu.option_menu)
                popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.menu_item_edit -> {
                            onEditClick?.invoke(activity)
                        }
                        R.id.menu_item_delete -> {
                            onDeleteClick?.invoke(activity)
                        }
                        else -> {
                        }
                    }
                    false
                }
                popupMenu.show()
            }
        }
    }
}
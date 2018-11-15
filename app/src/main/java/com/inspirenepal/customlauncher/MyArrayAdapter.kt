package com.inspirenepal.customlauncher

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.grid_items.view.*

class MyArrayAdapter(
    private val context: Context,
    private var appInfoList: List<AppInfo>
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_items, parent, false))
    }

    override fun getItemCount(): Int {
        return appInfoList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        viewHolder.itemView.appIcon.setImageDrawable(appInfoList[position].icon)
        viewHolder.itemView.appLabel!!.text = appInfoList[position].label
        viewHolder.itemView.appName!!.text = appInfoList[position].name
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}


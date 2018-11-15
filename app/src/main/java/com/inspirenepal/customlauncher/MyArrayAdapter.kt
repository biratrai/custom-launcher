package com.inspirenepal.customlauncher

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyArrayAdapter(
    private val context: Context,
    private var appInfoList: List<AppInfo>
) : BaseAdapter() {
    override fun getCount(): Int {
        return appInfoList.size
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return appInfoList[position]
    }

    fun setData(apps: List<AppInfo>) {
        this.appInfoList = apps
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.i("MyArrayAdapter", "MyArrayAdapter $position")
        var view = convertView
        val viewHolder: ViewHolderItem?

        if (view == null) {
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = layoutInflater.inflate(
                R.layout.grid_items, parent, false
            )
            viewHolder = ViewHolderItem()
            viewHolder.icon = view!!.findViewById(R.id.img_icon)
            viewHolder.name = view.findViewById(R.id.txt_name)
            viewHolder.label = view.findViewById(R.id.txt_label)

            view.tag = viewHolder
        } else viewHolder = view.tag as ViewHolderItem

        val appInfo = appInfoList[position]

        viewHolder.icon!!.setImageDrawable(appInfo.icon)
        viewHolder.label!!.text = appInfo.label
        viewHolder.name!!.text = appInfo.name
        return view

    }

    internal inner class ViewHolderItem {
        var icon: ImageView? = null
        var label: TextView? = null
        var name: TextView? = null
    }
}


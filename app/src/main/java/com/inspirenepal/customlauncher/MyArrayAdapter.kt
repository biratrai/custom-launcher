package com.inspirenepal.customlauncher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyArrayAdapter(
    context: Context,
    resource: Int,
    private val appInfoList: List<AppInfo>,
    private val layoutInflate: LayoutInflater
) : ArrayAdapter<AppInfo>(context, resource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHolder: ViewHolderItem? = null

        if (convertView == null) {
            convertView = layoutInflate.inflate(
                R.layout.grid_items, parent, false
            )
            viewHolder = ViewHolderItem()
            viewHolder.icon = convertView!!.findViewById(R.id.img_icon)
            viewHolder.name = convertView.findViewById(R.id.txt_name)
            viewHolder.label = convertView.findViewById(R.id.txt_label)

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolderItem
        }

        val appInfo = appInfoList[position]

        if (appInfo != null) {
            viewHolder.icon!!.setImageDrawable(appInfo.icon)
            viewHolder.label!!.text = appInfo.label
            viewHolder.name!!.text = appInfo.name
        }
        return convertView

    }

    internal inner class ViewHolderItem {
        var icon: ImageView? = null
        var label: TextView? = null
        var name: TextView? = null
    }
}


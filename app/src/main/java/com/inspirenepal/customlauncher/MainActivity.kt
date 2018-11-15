package com.inspirenepal.customlauncher

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var apps: MutableList<AppInfo> = mutableListOf()
    private var adapter: MyArrayAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApps()
//        addGridListeners()
    }

    private fun addGridListeners() {

    }

    private fun loadListView() {
        recyclerView.layoutManager = GridLayoutManager(this, 4)
        adapter = MyArrayAdapter(this, apps)
        recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    private fun loadApps() {
        val i = Intent(Intent.ACTION_MAIN, null)
        i.addCategory(Intent.CATEGORY_LAUNCHER)

        val availableApps = packageManager.queryIntentActivities(i, 0)
        for (resolveInfo in availableApps) {
            val appInfo = AppInfo(
                resolveInfo.loadLabel(packageManager)
                , resolveInfo.activityInfo.packageName
                , resolveInfo.activityInfo.loadIcon(packageManager)
            )

            Log.i("TAG", "Size of Apps $appInfo")
            apps.add(appInfo)
        }
        Log.i("TAG", "Size of Apps" + apps.size)
        loadListView()
    }

}

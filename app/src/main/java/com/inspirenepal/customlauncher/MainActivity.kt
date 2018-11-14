package com.inspirenepal.customlauncher

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var apps: MutableList<AppInfo> = mutableListOf()
    private var adapter: MyArrayAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApps()
        loadListView()
//        addGridListeners()
    }

    private fun addGridListeners() {

    }

    private fun loadListView() {
        adapter = MyArrayAdapter(this, R.layout.grid_items, apps, layoutInflater)
        gridAllApps.adapter = adapter
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
            apps.add(appInfo)
        }

    }

}

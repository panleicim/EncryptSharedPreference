package com.lpa.encryptedsharedpreferences.rawdata

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpa.encryptedsharedpreferences.R

class RawdataListActivity : AppCompatActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences(
            "secret_shared_prefs",
            Context.MODE_PRIVATE
        )
    }

    val mAdapter = RawDataAdapter(listOf(), this)

    val dataList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.dataList)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rawdata_list)
        dataList.layoutManager = LinearLayoutManager(this)
        dataList.adapter = mAdapter
    }

    override fun onResume() {
        super.onResume()
        val list: MutableList<RawDataModel> = ArrayList()
        sharedPreferences.all.forEach {
            list.add(RawDataModel(it.key, it.value as String))
        }
        mAdapter.reload(list)
    }
}
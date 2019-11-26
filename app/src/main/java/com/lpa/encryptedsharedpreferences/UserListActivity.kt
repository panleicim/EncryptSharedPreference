package com.lpa.encryptedsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {

    val r: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.userList)
    }
    val btnAddUser: Button by lazy {
        findViewById<Button>(R.id.btnAddUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpListeners()
        setContentView(R.layout.activity_main)
    }

    private fun setUpListeners() {
        btnAddUser.setOnClickListener {
            showCreateUserActivity()
        }
    }

    private fun showCreateUserActivity() {

    }
}

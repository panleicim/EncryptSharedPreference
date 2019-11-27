package com.lpa.encryptedsharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {

    val r: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.userList)
    }
    private val btnAddUser: Button by lazy {
        findViewById<Button>(R.id.btnAddUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners() {
        btnAddUser.setOnClickListener {
            showCreateUserActivity()
        }
    }

    private fun showCreateUserActivity() {
        val intent = Intent(this, CreateUserActivity::class.java)
        startActivity(intent)
    }
}

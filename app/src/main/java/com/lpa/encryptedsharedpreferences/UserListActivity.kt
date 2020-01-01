package com.lpa.encryptedsharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpa.encryptedsharedpreferences.adapter.UserItemAdapter
import com.lpa.encryptedsharedpreferences.contact.IUserListView
import com.lpa.encryptedsharedpreferences.model.UserModel

class UserListActivity : AppCompatActivity(), IUserListView {

    val userList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.userList)
    }
    val mPresenter:UserListPresenter by lazy{
        UserListPresenter(this,this.applicationContext)
    }
    override fun userListLoaded(list: List<UserModel>) {
        mAdapter.reload(list)

    }

    val mAdapter: UserItemAdapter = UserItemAdapter(listOf(), this)

    private val btnAddUser: Button by lazy {
        findViewById<Button>(R.id.btnAddUser)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadUsers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
    }


    private fun setUpListeners() {
        userList.layoutManager = LinearLayoutManager(this)
        userList.adapter = mAdapter

        btnAddUser.setOnClickListener {
            showCreateUserActivity()
        }
    }

    private fun showCreateUserActivity() {
        val intent = Intent(this, CreateUserActivity::class.java)
        startActivity(intent)
    }
}

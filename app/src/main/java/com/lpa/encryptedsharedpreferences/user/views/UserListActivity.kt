package com.lpa.encryptedsharedpreferences.user.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpa.encryptedsharedpreferences.R
import com.lpa.encryptedsharedpreferences.rawdata.RawdataListActivity
import com.lpa.encryptedsharedpreferences.user.adapter.UserItemAdapter
import com.lpa.encryptedsharedpreferences.user.contact.IUserListView
import com.lpa.encryptedsharedpreferences.user.model.UserModel
import com.lpa.encryptedsharedpreferences.user.presenters.UserListPresenter

class UserListActivity : AppCompatActivity(), IUserListView {

    val userList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.userList)
    }
    val mPresenter: UserListPresenter by lazy {
        UserListPresenter(
            this,
            this.applicationContext
        )
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

    fun showUnencrypted(view: View) {
        val intent = Intent(this, RawdataListActivity::class.java)
        startActivity(intent)
    }
}

package com.lpa.encryptedsharedpreferences

import android.content.Context
import com.lpa.encryptedsharedpreferences.contact.IUserListPresenter
import com.lpa.encryptedsharedpreferences.contact.IUserListView
import com.lpa.encryptedsharedpreferences.store.UserEncStoreImpl
import com.lpa.encryptedsharedpreferences.store.UserStore

class UserListPresenter(val view: IUserListView, val mContext: Context) : IUserListPresenter {


    val store: UserStore by lazy {
        UserEncStoreImpl(mContext)
    }


    override fun loadUsers() {
        store.loadAllUsers {
            view.userListLoaded(it)
        }
    }


}
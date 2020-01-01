package com.lpa.encryptedsharedpreferences.user.presenters

import android.content.Context
import com.lpa.encryptedsharedpreferences.user.contact.IUserListPresenter
import com.lpa.encryptedsharedpreferences.user.contact.IUserListView
import com.lpa.encryptedsharedpreferences.user.store.UserEncStoreImpl
import com.lpa.encryptedsharedpreferences.user.store.UserStore
import com.lpa.encryptedsharedpreferences.user.store.UserStoreImpl

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
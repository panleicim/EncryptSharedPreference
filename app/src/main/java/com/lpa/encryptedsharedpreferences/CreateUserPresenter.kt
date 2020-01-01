package com.lpa.encryptedsharedpreferences

import android.content.Context
import com.lpa.encryptedsharedpreferences.contact.ICreateUserPresenter
import com.lpa.encryptedsharedpreferences.contact.ICreateUserView
import com.lpa.encryptedsharedpreferences.model.UserModel
import com.lpa.encryptedsharedpreferences.store.UserEncStoreImpl
import com.lpa.encryptedsharedpreferences.store.UserStore

class CreateUserPresenter(val view: ICreateUserView, val mContext: Context) : ICreateUserPresenter {

    val store: UserStore by lazy {
        UserEncStoreImpl(mContext.applicationContext)
    }

    override fun showError(msg: String) {
        view.showError(msg)
    }

    override fun createUser(user: UserModel) {
        if (user.mailAddress.isNotEmpty()) {
            store.saveOrUpdate(user)
            view.onUserCreated()
        } else {
            showError(mContext.getString(R.string.mail_cannot_be_empty))
        }
    }

    override fun createUser(mailAddress: String, lastName: String, firstName: String) {
        createUser(UserModel(firstName, lastName, mailAddress))
    }

}
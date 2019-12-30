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

    override fun showError() {
    }

    override fun createUser(user: UserModel) {

    }

    override fun createUser(mailAddress: String, lastName: String, firstName: String) {
        if (mailAddress.isNotEmpty()) {
        } else {
            showError()
        }
    }

    private fun checkValidation(value: String) {

    }

}
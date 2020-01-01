package com.lpa.encryptedsharedpreferences.user.contact

import com.lpa.encryptedsharedpreferences.user.model.UserModel

interface ICreateUserPresenter {
    fun showError(msg:String)
    fun createUser(user: UserModel)
    fun createUser(mailAddress: String, lastName: String, firstName: String)
}
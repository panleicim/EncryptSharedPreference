package com.lpa.encryptedsharedpreferences.contact

import com.lpa.encryptedsharedpreferences.model.UserModel

interface ICreateUserPresenter {
    fun showError(msg:String)
    fun createUser(user: UserModel)
    fun createUser(mailAddress: String, lastName: String, firstName: String)
}
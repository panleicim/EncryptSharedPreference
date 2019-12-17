package com.lpa.encryptedsharedpreferences.contact

import com.lpa.encryptedsharedpreferences.model.UserModel

interface ICreateUserPresenter {
    fun showError()
    fun createUser(user: UserModel)
}
package com.lpa.encryptedsharedpreferences.store

import com.lpa.encryptedsharedpreferences.model.UserModel

interface UserStore {
    fun saveOrUpdate(user: UserModel)
    fun getUser(mailAddress: String): UserModel?
    fun deleteUser(mailAddress:String)
}
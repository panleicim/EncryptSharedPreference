package com.lpa.encryptedsharedpreferences.user.store

import com.lpa.encryptedsharedpreferences.user.model.UserModel

interface UserStore {
    fun saveOrUpdate(user: UserModel)
    fun getUser(mailAddress: String): UserModel?
    fun deleteUser(mailAddress:String)
    fun loadAllUsers(success: (List<UserModel>) -> Unit)
}
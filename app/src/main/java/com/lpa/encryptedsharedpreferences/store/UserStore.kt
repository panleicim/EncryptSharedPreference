package com.lpa.encryptedsharedpreferences.store

interface UserStore {
    fun saveOrUpdate(user: UserModel)
    fun getUser(mailAddress: String): UserModel?
    fun deleteUser(mailAddress:String)
}
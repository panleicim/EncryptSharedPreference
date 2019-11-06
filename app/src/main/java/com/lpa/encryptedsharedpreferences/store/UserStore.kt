package com.lpa.encryptedsharedpreferences.store

interface UserStore {
    fun getUser(): UserModel?
    fun saveOrUpdate(user: UserModel)
    fun deleteUser()
    fun createUser(): UserModel
}
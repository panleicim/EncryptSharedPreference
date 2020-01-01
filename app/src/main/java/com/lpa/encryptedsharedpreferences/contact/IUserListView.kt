package com.lpa.encryptedsharedpreferences.contact

import com.lpa.encryptedsharedpreferences.model.UserModel

interface IUserListView {
    fun userListLoaded(list:List<UserModel>)

}
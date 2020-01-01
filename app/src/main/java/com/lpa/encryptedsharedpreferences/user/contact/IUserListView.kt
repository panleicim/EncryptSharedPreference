package com.lpa.encryptedsharedpreferences.user.contact

import com.lpa.encryptedsharedpreferences.user.model.UserModel

interface IUserListView {
    fun userListLoaded(list:List<UserModel>)

}
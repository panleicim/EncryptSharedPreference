package com.lpa.encryptedsharedpreferences.user.store

import android.content.Context
import com.google.gson.Gson
import com.lpa.encryptedsharedpreferences.user.model.UserModel

class UserStoreImpl(@Transient val mContext: Context) : UserStore {

    companion object {

        private lateinit var instance: UserStore

        fun init(context: Context) {
            instance = UserEncStoreImpl(context)
        }

        fun getInstance(): UserStore = instance
    }


    private val gson = Gson()

    private val sharedPreferences by lazy {
        mContext.getSharedPreferences(
            "secret_shared_prefs",
            Context.MODE_PRIVATE
        )
    }

    override fun loadAllUsers(success: (List<UserModel>) -> Unit) {
        val usersMap = sharedPreferences.all
        val userList: MutableList<UserModel> = ArrayList()
        usersMap.values.forEach {
            userList.add(
                gson.fromJson(
                    it as String,
                    UserModel::class.java
                )
            )
        }
        success.invoke(userList)
    }

    override fun getUser(mailAddress: String): UserModel? {
        val userInJsonString = sharedPreferences.getString(mailAddress, null)
        return if (userInJsonString != null)
            gson.fromJson(
                userInJsonString,
                UserModel::class.java
            )
        else null
    }

    override fun saveOrUpdate(user: UserModel) {
        // use the shared preferences and editor as you normally would
        sharedPreferences.edit().putString(user.mailAddress, gson.toJson(user)).apply()
    }

    override fun deleteUser(mailAddress: String) {
        sharedPreferences.edit().remove(mailAddress).apply()
    }

}
package com.lpa.encryptedsharedpreferences.store

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson
import com.lpa.encryptedsharedpreferences.model.UserModel


class UserEncStoreImpl(@Transient val mContext: Context) : UserStore {


    companion object {

        private lateinit var instance: UserStore

        fun init(context: Context) {
            instance = UserEncStoreImpl(context)
        }

        fun getInstance(): UserStore = instance
    }

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val gson = Gson()

    private val sharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            "secret_shared_prefs",
            masterKeyAlias,
            mContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
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
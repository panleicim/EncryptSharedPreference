package com.lpa.encryptedsharedpreferences.store

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson


class UserStoreImpl(@Transient val mContext: Context) : UserStore {

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


    override fun getUser(): UserModel? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveOrUpdate(user: UserModel) {
        // use the shared preferences and editor as you normally would
        sharedPreferences.edit().putString(user.mailAddress, gson.toJson(user)).apply()
    }

    override fun deleteUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(): UserModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
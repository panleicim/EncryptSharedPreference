package com.lpa.encryptedsharedpreferences

import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceActivity
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class CreateUserActivity : PreferenceActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user_activity)
    }
}
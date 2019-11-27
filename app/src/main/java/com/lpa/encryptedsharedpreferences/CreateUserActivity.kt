package com.lpa.encryptedsharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class CreateUserActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, CreatUserFragment())
            .commit()
    }
}

class CreatUserFragment : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.user_info, rootKey)
    }

}
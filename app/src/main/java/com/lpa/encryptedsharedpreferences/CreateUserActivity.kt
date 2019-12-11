package com.lpa.encryptedsharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class CreateUserActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_step_two_content)
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.container, CreateUserFragment())
//            .commit()
    }
}

class CreateUserFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.user_info)
    }


}
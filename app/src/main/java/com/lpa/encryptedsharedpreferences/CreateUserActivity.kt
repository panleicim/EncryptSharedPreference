package com.lpa.encryptedsharedpreferences

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lpa.encryptedsharedpreferences.utils.log

class CreateUserActivity : AppCompatActivity() {

    companion object {
        const val TAG = "CreateUserActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_step_two_content)

    }

    fun onValidClicked(view: View) {
        log("create user", TAG)
    }
}

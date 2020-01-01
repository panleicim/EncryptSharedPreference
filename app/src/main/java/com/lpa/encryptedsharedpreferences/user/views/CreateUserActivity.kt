package com.lpa.encryptedsharedpreferences.user.views

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.lpa.encryptedsharedpreferences.R
import com.lpa.encryptedsharedpreferences.user.contact.ICreateUserPresenter
import com.lpa.encryptedsharedpreferences.user.contact.ICreateUserView
import com.lpa.encryptedsharedpreferences.user.presenters.CreateUserPresenter
import com.lpa.encryptedsharedpreferences.utils.log
import org.jetbrains.anko.toast

class CreateUserActivity : AppCompatActivity(), ICreateUserView {
    override fun showError(msg: String) {
        toast(msg)
    }

    companion object {
        const val TAG = "CreateUserActivity"
    }

    val mPresenter: ICreateUserPresenter by lazy {
        CreateUserPresenter(this, this)
    }
    val edtFirstName: EditText by lazy {
        findViewById<EditText>(R.id.edtFirstName)
    }
    val edtLastName: EditText by lazy {
        findViewById<EditText>(R.id.edtLastName)
    }

    val etMail: EditText by lazy {
        findViewById<EditText>(R.id.etMail)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user_layout)
    }

    fun onValidClicked(view: View) {
        log("create user",
            TAG
        )
        mPresenter.createUser(
            etMail.text.toString(),
            edtLastName.text.toString(),
            edtFirstName.text.toString()
        )
    }

    override fun onUserCreated() {

        toast(R.string.msg_user_created).show()
        finish()
    }
}

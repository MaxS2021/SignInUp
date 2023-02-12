package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.listtest.costance.Constance
import com.example.listtest.databinding.ActivitySigninupBinding

class SignInUpAct : AppCompatActivity() {

    lateinit var bindingClass: ActivitySigninupBinding
    private var signState = "am"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySigninupBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_signinup)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!

        if(signState == Constance.SIGN_IN_STATE) {
            bindingClass.edName1.visibility = View.GONE
            bindingClass.edName2.visibility = View.GONE
            bindingClass.edName3.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE
        }

    }

    fun onClickDone (view: View) {
        if(signState == Constance.SIGN_UP_STATE) {

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.efLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName1.text.toString())
            intent.putExtra(Constance.FAMILY, bindingClass.edName2.text.toString())
            intent.putExtra(Constance.EMAIL, bindingClass.edName3.text.toString())
            if (bindingClass.imAvatar.isVisible) intent.putExtra(Constance.AVATAR_ID, R.drawable.max_encoder)
            setResult(RESULT_OK, intent)
            finish()
        } else if (signState == Constance.SIGN_IN_STATE) {
            intent.putExtra(Constance.LOGIN, bindingClass.efLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }

    fun onClickAvatar (view: View) {
            bindingClass.imAvatar.visibility = View.VISIBLE
    }
}
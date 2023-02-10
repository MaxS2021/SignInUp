package com.example.listtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        if(signState == Constance.SIGN_IN_STATE) {

        }
    }

    fun onClickAvatar (view: View) {
            bindingClass.imAvatar.visibility = View.VISIBLE
    }
}
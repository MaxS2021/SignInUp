package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.listtest.R.*
import com.example.listtest.R.array.*
import com.example.listtest.costance.Constance
import com.example.listtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

//    val arr: Array<String>
//        get() = resources.getStringArray(/* id = */ lst)
    lateinit var bindingClass: ActivityMainBinding

    private var login: String = "empty"
    private var password: String = "empty"
    private var name1: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

//        for (dg in arr) {
//            Log.d("AppLog", "onCreate Var dg = $dg")
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==Constance.REQUEST_CODE_SIGN_IN) {
            val lgn = data?.getStringExtra(Constance.LOGIN)
            val pwd = data?.getStringExtra(Constance.PASSWORD)
            bindingClass.imAvatar1.visibility = View.VISIBLE
            if (login == lgn && password == pwd ) {
                bindingClass.imAvatar1.setImageResource(avatarImageId)
                bindingClass.textView.text = "$name1 $name2 $name3"
                bindingClass.bSignUp.text = "Выход"
                bindingClass.bSignIn.text = "Продолжить"
            } else {
                bindingClass.imAvatar1.setImageResource(R.drawable.cat0)
                bindingClass.textView.text = "Такого аккаунта не существует!"
            }


        } else if (requestCode==Constance.REQUEST_CODE_SIGN_UP) {
            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name1 = data.getStringExtra(Constance.NAME)!!
            name2 = data.getStringExtra(Constance.FAMILY)!!
            name3 = data.getStringExtra(Constance.EMAIL)!!
            bindingClass.imAvatar1.visibility = View.VISIBLE
            avatarImageId = data.getIntExtra(Constance.AVATAR_ID, 0)
            bindingClass.imAvatar1.setImageResource(avatarImageId)
            bindingClass.textView.text = "$name1 $name2 $name3"
            bindingClass.bSignUp.text = "Выход"
            bindingClass.bSignIn.text = "Продолжить"



        }
    }

    fun onClickSignIn(view: View) {

        if (bindingClass.imAvatar1.isVisible && bindingClass.textView.text.toString() != "Такого аккаунта не существует!") {
            val intent = Intent(this, LastActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_LAST)
            intent.putExtra(Constance.LOGIN, login)
            intent.putExtra(Constance.PASSWORD, password)
            intent.putExtra(Constance.NAME, name1)
            intent.putExtra(Constance.FAMILY, name2)
            intent.putExtra(Constance.EMAIL, name3)
            intent.putExtra(Constance.AVATAR_ID, avatarImageId)
            startActivityForResult(intent, Constance.REQUEST_CODE_LAST)

        } else {

            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }
    }

    fun onClickSignUp(view: View) {
        if (bindingClass.imAvatar1.isVisible && bindingClass.textView.text.toString() != "Такого аккаунта не существует!") {
            finish()
        } else {
            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
        }
    }

}
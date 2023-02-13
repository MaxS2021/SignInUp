package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.listtest.R.*
import com.example.listtest.R.array.*
import com.example.listtest.costance.Constance
import com.example.listtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    private var login: String = "empty"
    private var password: String = "empty"
    private var name1: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0

    private var launcher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        var signStateMain = "a"
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                signStateMain = result.data?.getStringExtra(Constance.SIGN_STATE)!!

                if (signStateMain == Constance.SIGN_IN_STATE) {
                    val lgn = result.data?.getStringExtra(Constance.LOGIN)
                    val pwd = result.data?.getStringExtra(Constance.PASSWORD)
                    bindingClass.imAvatar1.visibility = View.VISIBLE
                    Log.d("AppLog", "Login: $lgn Password: $pwd")
                    if (login == lgn && password == pwd) {
                        Log.d("AppLog", "Contact!!!")
                        bindingClass.imAvatar1.setImageResource(avatarImageId)
                        bindingClass.textView.text = "$name1 $name2 $name3"
                        bindingClass.bSignUp.text = "Выход"
                        bindingClass.bSignIn.text = "Продолжить"
                    } else {
                        Log.d("AppLog", "Not found!")
                        bindingClass.imAvatar1.setImageResource(R.drawable.cat0)
                        bindingClass.textView.text = "Такого аккаунта не существует!"
                    }
                } else if (signStateMain == Constance.SIGN_UP_STATE) {
                    login = result.data?.getStringExtra(Constance.LOGIN)!!
                    password = result.data?.getStringExtra(Constance.PASSWORD)!!
                    name1 = result.data?.getStringExtra(Constance.NAME)!!
                    name2 = result.data?.getStringExtra(Constance.FAMILY)!!
                    name3 = result.data?.getStringExtra(Constance.EMAIL)!!
                    bindingClass.imAvatar1.visibility = View.VISIBLE
                    avatarImageId = result.data?.getIntExtra(Constance.AVATAR_ID, 0)!!
                    bindingClass.imAvatar1.setImageResource(avatarImageId)
                    bindingClass.textView.text = "$name1 $name2 $name3"
                    bindingClass.bSignUp.text = "Выход"
                    bindingClass.bSignIn.text = "Продолжить"
                }
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode==Constance.REQUEST_CODE_SIGN_IN) {
//            val lgn = data?.getStringExtra(Constance.LOGIN)
//            val pwd = data?.getStringExtra(Constance.PASSWORD)
//            bindingClass.imAvatar1.visibility = View.VISIBLE
//            if (login == lgn && password == pwd ) {
//                bindingClass.imAvatar1.setImageResource(avatarImageId)
//                bindingClass.textView.text = "$name1 $name2 $name3"
//                bindingClass.bSignUp.text = "Выход"
//                bindingClass.bSignIn.text = "Продолжить"
//            } else {
//                bindingClass.imAvatar1.setImageResource(R.drawable.cat0)
//                bindingClass.textView.text = "Такого аккаунта не существует!"
//            }
//
//
//        } else if (requestCode==Constance.REQUEST_CODE_SIGN_UP) {
//            login = data?.getStringExtra(Constance.LOGIN)!!
//            password = data.getStringExtra(Constance.PASSWORD)!!
//            name1 = data.getStringExtra(Constance.NAME)!!
//            name2 = data.getStringExtra(Constance.FAMILY)!!
//            name3 = data.getStringExtra(Constance.EMAIL)!!
//            bindingClass.imAvatar1.visibility = View.VISIBLE
//            avatarImageId = data.getIntExtra(Constance.AVATAR_ID, 0)
//            bindingClass.imAvatar1.setImageResource(avatarImageId)
//            bindingClass.textView.text = "$name1 $name2 $name3"
//            bindingClass.bSignUp.text = "Выход"
//            bindingClass.bSignIn.text = "Продолжить"
//
//
//
//        }
//    }

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
            //startActivityForResult(intent, Constance.REQUEST_CODE_LAST)
            startActivity(intent)

        } else {

            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            launcher?.launch(intent)
            //startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }
    }

    fun onClickSignUp(view: View) {
        if (bindingClass.imAvatar1.isVisible && bindingClass.textView.text.toString() != "Такого аккаунта не существует!") {
            finish()
        } else {
            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
            launcher?.launch(intent)
            //startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
        }
    }

}
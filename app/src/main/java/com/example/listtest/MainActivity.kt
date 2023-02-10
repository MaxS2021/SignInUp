package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.listtest.R.*
import com.example.listtest.R.array.*
import com.example.listtest.costance.Constance


class MainActivity : AppCompatActivity() {

//    val arr: Array<String>
//        get() = resources.getStringArray(/* id = */ lst)
//    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name1: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)



//        for (dg in arr) {
//            Log.d("AppLog", "onCreate Var dg = $dg")
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==Constance.REQUEST_CODE_SIGN_IN) {

        } else if (requestCode==Constance.REQUEST_CODE_SIGN_UP) {

        }
    }

    fun onClickSignIn(view: View) {
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
    }

    fun onClickSignUp(view: View) {
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }

}
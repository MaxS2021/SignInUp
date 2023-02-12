package com.example.listtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.listtest.costance.Constance
import com.example.listtest.databinding.ActivityLastBinding

class LastActivity : AppCompatActivity() {
    lateinit var bnd: ActivityLastBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name1: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0

    private var signState = "a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = ActivityLastBinding.inflate(layoutInflater)
        setContentView(bnd.root)
        supportActionBar?.hide()

        login = intent.getStringExtra(Constance.LOGIN)!!
        password = intent.getStringExtra(Constance.PASSWORD)!!
        name1 = intent.getStringExtra(Constance.NAME)!!
        name2 = intent.getStringExtra(Constance.FAMILY)!!
        name3 = intent.getStringExtra(Constance.EMAIL)!!
        avatarImageId = intent.getIntExtra(Constance.AVATAR_ID, 0)
        bnd.idAvatar2.setImageResource(avatarImageId)
        bnd.textView2.text = "$name1 $name2 \n$name3"

    }
}
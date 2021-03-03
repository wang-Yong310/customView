package com.example.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEvent()
    }

    private fun initEvent() {
        btn_input_number.setOnClickListener{
            var intent: Intent = Intent(this, InputNumberActivity::class.java)
            startActivity(intent)
        }
        btn_login_keyboard?.setOnClickListener{
            var intent: Intent = Intent(this, LoginKeyboardActivity::class.java)
            startActivity(intent)
        }
        //跳转到登录页面 login activity
        btn_login?.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
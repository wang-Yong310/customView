package com.example.customview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.customview.loginpage.LoginKeyboard

class LoginKeyboardActivity : AppCompatActivity()  {
    private var TAG : String = "LoginKeyboardActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.num_key_pad)

        var loginKeyboard: LoginKeyboard = findViewById<LoginKeyboard>(R.id.number_key_pad)
        loginKeyboard.setOnKeyPressListener(object : LoginKeyboard.OnKeyPressListener {
            override fun onNumberPress(number: Int) {
                Log.d(TAG,"current click value is == > $number")
            }

            override fun onBackPress() {
                Log.d(TAG,"on back press ..")
            }
        })
    }
}

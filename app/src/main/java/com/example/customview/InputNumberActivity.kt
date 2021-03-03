package com.example.customview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input.*

class InputNumberActivity : AppCompatActivity(), InputNumberView.OnNumberChangerListener {
    private val TAG: String = "InputNumberActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        input_number_view.setOnNumberChangeListener(this)
    }

    override fun onNumberChange(value: Int) {
        Log.d(TAG, "input number value == > $value")
    }
}

package com.example.customview.loginpage

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.forEachIndexed
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_login.view.*

/**
 * @author wangyong
 * @date 2/24/21 7:34 PM
 */
class LoginKeyboard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {
    private val TAG = "LoginKeyboard"
    private lateinit var mKeyPressListener: OnKeyPressListener

    init {
        Log.d(TAG, "initView")
        initView()
    }

    private fun initView() {
        var view = LayoutInflater.from(context).inflate(R.layout.activity_login, this, false)
        addView(view)
        this.findViewById<TextView>(R.id.tv_number_0).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_1).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_2).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_3).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_4).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_5).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_6).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_7).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_8).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_number_9).setOnClickListener(this)
        this.findViewById<TextView>(R.id.tv_delete).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var viewId: Int = v?.id
        if (viewId == R.id.tv_delete) {
            //走back
            mKeyPressListener.onBackPress()
        } else {
            //走数字结果通知
            var text: String = (v as TextView).text.toString()
            Log.d(TAG, "click text == >$text")
            mKeyPressListener.onNumberPress(text.toInt())
        }
    }


    fun setOnKeyPressListener(listener: OnKeyPressListener) {
        this.mKeyPressListener = listener
    }

    interface OnKeyPressListener {
        fun onNumberPress(number: Int)

        fun onBackPress()
    }
}

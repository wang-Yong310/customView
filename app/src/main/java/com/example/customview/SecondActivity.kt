package com.example.customview

import android.app.Activity
import android.os.Bundle
import android.os.Process
import com.example.customview.MyUtils.MyUtils

/**
 * @author wangyong
 * @date 2/3/21 9:01 PM
 */
class SecondActivity : Activity() {
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var processName: String? = MyUtils.getAppName(applicationContext, Process.myPid())

    }
}
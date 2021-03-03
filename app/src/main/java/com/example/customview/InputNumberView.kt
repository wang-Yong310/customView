package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.inputnumberview.view.*
import java.math.RoundingMode.valueOf

/*
 * @author wangyong
 * @date 2/1/21 2:29 PM
 */
class InputNumberView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var mCurrentNumber = 0
    private var mOnNumberChangerListener: OnNumberChangerListener? = null
    private val TAG = "InputNumberView"
    val a = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView)
    val mMax = a.getInt(R.styleable.InputNumberView_max, 0)
    val mMin = a.getInt(R.styleable.InputNumberView_min, 0)
    var mBtBgRes = a.getResourceId(R.styleable.InputNumberView_btBgRes, -1)
    var mDefaultValue = a.getResourceId(R.styleable.InputNumberView_defaultValue, 3)
    var mStep = a.getInt(R.styleable.InputNumberView_step, 2)
    var mDisable = a.getBoolean(R.styleable.InputNumberView_disable, false)

    init {
        initView(context)
        setUpEvent()
        initAttrs(context, attrs)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        //获取相关属性
        Log.d(TAG, "max ==> $mMax")
        Log.d(TAG, "min ==> $mMin")
        Log.d(TAG, "btBgRes ==> $mBtBgRes")
        Log.d(TAG, "defaultValue ==> $mDefaultValue")
        Log.d(TAG, "step ==> $mStep")
        Log.d(TAG, "disable ==> $mDisable")
        this.mCurrentNumber = mDefaultValue
        updateText()
    }

    private fun setUpEvent() {
        btn_sub.setOnClickListener {
            mCurrentNumber -= mStep
            if (mCurrentNumber <= mMin && mMin != 0) {
                btn_sub?.isEnabled = false
                mCurrentNumber = mMin
                Log.d(TAG, "current is min value ...")
            } else {
                btn_sub?.isEnabled = true
            }
            updateText()

        }
        btn_sum.setOnClickListener {
            mCurrentNumber += mStep
            if (mCurrentNumber >= mMax && mMax != 0) {
                btn_sum?.isEnabled = false
                mCurrentNumber = mMax
                Log.d(TAG, "current is max value ...")
            } else {
                btn_sum?.isEnabled = true
            }
            updateText()
        }
    }

    private fun updateText() {
        tv_number?.setText(mCurrentNumber.toString())
        mOnNumberChangerListener?.onNumberChange(this.mCurrentNumber)
    }

    private fun initView(context: Context) {
        var view: View = LayoutInflater.from(context).inflate(R.layout.inputnumberview, this, false)
        //   btn_sum.isEnabled = !mDisable
        addView(view)
    }

    fun setOnNumberChangeListener(listener: OnNumberChangerListener) {
        mOnNumberChangerListener = listener
    }

    interface OnNumberChangerListener {
        fun onNumberChange(value: Int)
    }

    fun getNumber(): Int {
        return mCurrentNumber
    }

    fun setNumber(value: Int) {
        mCurrentNumber = value
        this.updateText()
    }


}


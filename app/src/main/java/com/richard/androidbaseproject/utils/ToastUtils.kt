package com.richard.androidbaseproject.utils

import android.view.Gravity
import android.widget.Toast
import com.richard.androidbaseproject.GlobalApp

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/7 0007 13:47
 * @email：zhangyang5547662@126.com
 */
class ToastUtils {

    companion object {

        fun showLong(msg: String?) {
            val toast = Toast.makeText(GlobalApp.mContext, msg, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }

        fun showShort(msg: String?) {
            val toast = Toast.makeText(GlobalApp.mContext, msg, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}
package com.richard.androidbaseproject.model

import android.text.TextUtils

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/6 0006 18:40
 * @email：zhangyang5547662@126.com
 */
class HomeDataRespModel {

    var code = ""
    var msg = ""

    fun isOk(): Boolean {
        return TextUtils.equals("0", code)
    }

}
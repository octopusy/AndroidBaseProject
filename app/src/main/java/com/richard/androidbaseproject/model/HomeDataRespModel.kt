package com.richard.androidbaseproject.model

import android.text.TextUtils

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/6 0006 18:40
 * @email：zhangyang5547662@126.com
 */
class HomeDataRespModel {

    var errorCode = ""
    var errorMsg = ""
    var data:HomeDataModel? = null

    fun isOk(): Boolean {
        return TextUtils.equals("0", errorCode)
    }

    inner class HomeDataModel {
        var curPage = ""
        var offset = ""
        var over = ""
        var pageCount = ""
        var size = ""
        var total = ""
        var datas:List<HomeData>? = null

        override fun toString(): String {
            return "HomeDataModel(curPage='$curPage', offset='$offset', over='$over', " +
                    "pageCount='$pageCount', size='$size', total='$total', datas=$datas)"
        }
    }

    override fun toString(): String {
        return "HomeDataRespModel(errorCode='$errorCode', errorMsg='$errorMsg', data=$data)"
    }

}
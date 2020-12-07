package com.richard.androidbaseproject.view

import android.os.Bundle
import android.widget.Toast
import com.richard.androidbaseproject.R
import com.richard.androidbaseproject.config.ConstantConfig
import com.richard.androidbaseproject.model.HomeDataRespModel
import com.richard.androidbaseproject.present.HomeContract
import com.richard.androidbaseproject.present.HomeDataContract
import com.richard.androidbaseproject.present.HomeRequsetPresent
import com.richard.androidbaseproject.utils.ToastUtils

class MainActivity : BaseMvpActivity<HomeRequsetPresent, HomeContract>(), HomeDataContract.View {

    private var currentPageNum:Int = 0

    override fun getBundleExtras(extras: Bundle?) {}

    override fun getContentViewLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        requestData()
    }

    private fun requestData() {
        mPersenter.requestHomeData(ConstantConfig.URL_REQUEST_HOME_DATA + currentPageNum + "/json")
    }

    override fun requestResult(homeDataRespModel: HomeDataRespModel) {
        ToastUtils.showShort(homeDataRespModel.msg)
    }

    override fun requestFailResult(errMsg: String) {
        ToastUtils.showShort(errMsg)
    }

}

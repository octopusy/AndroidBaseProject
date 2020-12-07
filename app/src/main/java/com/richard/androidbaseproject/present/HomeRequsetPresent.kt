package com.richard.androidbaseproject.present

import com.axl.android.frameworkbase.net.utils.ProgressSubscriber
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.richard.androidbaseproject.model.HomeDataReqModel
import com.richard.androidbaseproject.model.HomeDataRespModel
import com.richard.androidbaseproject.utils.MySubscriber

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/6 0006 22:33
 * @email：zhangyang5547662@126.com
 */
class HomeRequsetPresent : HomeDataContract.IRequestPersenter() {

    override fun requestHomeData(url: String) {
        mModel.requestHomeData(object : MySubscriber<HomeDataRespModel>(mView.context) {
            override fun _onNext(t: HomeDataRespModel?) {
                Logger.d(Gson().toJson(t))
                if (t!!.isOk()) {
                    //解密 encryptData
                    mView.requestResult(t)
                } else {
                    mView.requestFailResult(t.errorMsg)
                }
            }

            override fun _onError(message: String?) {
                Logger.e(message)
            }
        }, url)
    }

}
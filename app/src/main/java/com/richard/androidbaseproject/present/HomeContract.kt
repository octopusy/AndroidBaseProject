package com.richard.androidbaseproject.present

import com.axl.android.frameworkbase.net.HttpEngine
import com.axl.android.frameworkbase.net.utils.ProgressSubscriber
import com.axl.android.frameworkbase.net.utils.RxSchedulersHelper
import com.richard.androidbaseproject.model.HomeDataRespModel

class HomeContract:HomeDataContract.IRequestHomeDataModel {

    override fun requestHomeData(subscriber: ProgressSubscriber<HomeDataRespModel>, url:String) {
        HttpEngine.getInstance().createServices(IRequestServiceManager::class.java)
            .requestHomeData(url)
            .compose(RxSchedulersHelper.io_main())
            .subscribe(subscriber)
    }

}
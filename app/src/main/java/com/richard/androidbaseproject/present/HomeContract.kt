package com.richard.androidbaseproject.present

import com.axl.android.frameworkbase.net.HttpEngine
import com.axl.android.frameworkbase.net.utils.RxSchedulersHelper
import com.richard.androidbaseproject.model.HomeDataRespModel
import com.richard.androidbaseproject.utils.MySubscriber

class HomeContract:HomeDataContract.IRequestHomeDataModel {

    override fun requestHomeData(subscriber: MySubscriber<HomeDataRespModel>, url:String) {
        HttpEngine.getInstance().createServices(IRequestServiceManager::class.java)
            .requestHomeData(url)
            .compose(RxSchedulersHelper.io_main())
            .subscribe(subscriber)
    }

}
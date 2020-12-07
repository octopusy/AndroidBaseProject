package com.richard.androidbaseproject.present

import com.richard.androidbaseproject.model.HomeDataRespModel
import com.richard.androidbaseproject.utils.MySubscriber

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/6 0006 18:39
 * @email：zhangyang5547662@126.com
 */
class HomeDataContract {

    interface IRequestHomeDataModel : BaseModel {
        fun requestHomeData(subscriber: MySubscriber<HomeDataRespModel>, url:String)
    }

    abstract class IRequestPersenter : BasePersenter<HomeDataContract.View, HomeDataContract.IRequestHomeDataModel>() {
        abstract fun requestHomeData(url:String)
    }

    interface View : IbaseView<Any> {
        fun requestResult(homeDataRespModel: HomeDataRespModel)

        fun requestFailResult(errMsg:String)
    }
    
}
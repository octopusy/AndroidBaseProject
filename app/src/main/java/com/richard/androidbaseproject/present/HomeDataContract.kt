package com.richard.androidbaseproject.present

import com.axl.android.frameworkbase.net.utils.ProgressSubscriber
import com.richard.androidbaseproject.model.HomeDataReqModel
import com.richard.androidbaseproject.model.HomeDataRespModel

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/6 0006 18:39
 * @email：zhangyang5547662@126.com
 */
class HomeDataContract {

    interface IRequestHomeDataModel : BaseModel {
        fun requestHomeData(subscriber: ProgressSubscriber<HomeDataRespModel>, url:String)
    }

    abstract class IRequestPersenter : BasePersenter<HomeDataContract.View, HomeDataContract.IRequestHomeDataModel>() {
        abstract fun requestHomeData(url:String)
    }

    interface View : IbaseView<Any> {
        fun requestResult(homeDataRespModel: HomeDataRespModel)

        fun requestFailResult(errMsg:String)
    }
    
}
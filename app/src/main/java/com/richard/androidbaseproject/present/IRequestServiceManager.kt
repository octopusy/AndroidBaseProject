package com.richard.androidbaseproject.present

import com.richard.androidbaseproject.model.HomeDataRespModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Url

interface IRequestServiceManager {

    @GET
    fun requestHomeData(@Url url:String): Flowable<HomeDataRespModel>
}
package com.richard.androidbaseproject

import android.content.Context
import android.content.pm.ApplicationInfo
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.axl.android.frameworkbase.BaseApplication
import com.axl.android.frameworkbase.net.HttpEngine
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.BuildConfig
import com.orhanobut.logger.Logger
import com.richard.androidbaseproject.config.ConstantConfig
import com.richard.androidbaseproject.utils.VersionHelper

/**
 * 程序入口
 */
class GlobalApp : MultiDexApplication(){

    companion object {
        lateinit var mContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        MultiDex.install(this)

        BaseApplication.getInstance().initApp(mContext)
        HttpEngine.init(ConstantConfig.APP_BASE_URL)

        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }


}
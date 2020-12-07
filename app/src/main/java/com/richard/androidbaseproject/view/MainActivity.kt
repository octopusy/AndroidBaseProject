package com.richard.androidbaseproject.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.orhanobut.logger.Logger
import com.richard.androidbaseproject.R
import com.richard.androidbaseproject.adapter.HomeDataAdapter
import com.richard.androidbaseproject.config.ConstantConfig
import com.richard.androidbaseproject.model.HomeDataRespModel
import com.richard.androidbaseproject.present.HomeContract
import com.richard.androidbaseproject.present.HomeDataContract
import com.richard.androidbaseproject.present.HomeRequsetPresent
import com.richard.androidbaseproject.utils.ToastUtils
import com.scwang.smartrefresh.header.WaterDropHeader
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<HomeRequsetPresent, HomeContract>(), HomeDataContract.View {

    private var currentPageNum:Int = 0
    private var isRefresh:Boolean = false
    private var adapter: HomeDataAdapter? = null
    private var mBundle:Bundle? = null

    override fun getBundleExtras(extras: Bundle?) {}

    override fun getContentViewLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolbar.setCenterTitle("测试App")
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        recycler_home.layoutManager = LinearLayoutManager(this)
        recycler_home.isNestedScrollingEnabled = false
        adapter = HomeDataAdapter()
        recycler_home.adapter = adapter

        adapter!!.setOnItemClickLitener { v, dataModel, position ->
            mBundle = Bundle()
            mBundle!!.putString("title",dataModel.title)
            mBundle!!.putString("url",dataModel.link)
            openActivity(WebViewActivity::class.java,mBundle)
        }

        refresh_home.autoRefresh()
        refresh_home.setOnRefreshListener { refreshlayout ->
            isRefresh = true
            adapter!!.clear()
            currentPageNum = 0
            //上拉刷新
            requestData()
            refreshlayout.finishRefresh(1500)
        }
        refresh_home.setOnLoadmoreListener { refreshlayout ->
            isRefresh = false
            currentPageNum++
            //下拉加载
            requestData()
            refreshlayout.finishLoadmore(1500)
        }
        refresh_home.isEnableLoadmore = true
        refresh_home.refreshHeader = WaterDropHeader(this)
        refresh_home.refreshFooter = BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale)
    }

    private fun requestData() {
        mPersenter.requestHomeData(ConstantConfig.URL_REQUEST_HOME_DATA + currentPageNum + "/json")
    }

    override fun requestResult(homeDataRespModel: HomeDataRespModel) {
        try {
            adapter!!.appendToList(homeDataRespModel.data!!.datas)
        } catch (e:Exception) {
            Logger.e(e.message)
        }
    }

    override fun requestFailResult(errMsg: String) {
        ToastUtils.showShort(errMsg)
    }

}

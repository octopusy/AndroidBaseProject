package com.richard.androidbaseproject.view

import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import com.axl.android.frameworkbase.ui.ToolBarActivity
import com.orhanobut.logger.Logger
import com.richard.androidbaseproject.R
import kotlinx.android.synthetic.main.activity_webview_layout.*


/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/11/6
 * Time: 15:39
 */
class WebViewActivity : ToolBarActivity() {

    private var title: String = ""
    private var url: String = ""

    override fun initToolBar() {
        mToolbar.setCenterTitle(title)
        mToolbar.setNavigationOnClickListener {
            if(null != webView && webView.canGoBack()) {
                webView.goBack()   //后退
            } else {
                this@WebViewActivity.finish()
            }
        }
    }

    override fun getBundleExtras(extras: Bundle) {
        title = extras.getString("title")
        url = extras.getString("url")
        Logger.i("URL:$url")
    }

    override fun getContentViewLayoutID(): Int = R.layout.activity_webview_layout

    override fun initViewsAndEvents() {
        //webView配置相关信息
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.setGeolocationEnabled(true) //启用地理定位
        webSettings.databaseEnabled = true//启用数据库
        webSettings.domStorageEnabled = true
        webSettings.allowFileAccess = true
        webSettings.blockNetworkImage = false
        webSettings.useWideViewPort = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        webSettings.loadWithOverviewMode = true

        if (Build.VERSION.SDK_INT >= 27) {
            webSettings.safeBrowsingEnabled = false
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {
                result.confirm()
                return true
            }

            override fun onGeolocationPermissionsShowPrompt(origin: String, callback: GeolocationPermissions.Callback) {
                callback.invoke(origin, true, false)
                super.onGeolocationPermissionsShowPrompt(origin, callback)
            }
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
            }
        }

        webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack()   //后退
                    return@OnKeyListener true    //已处理
                }
            }
            false
        })
        webView.loadUrl(url)
    }

    override fun getLoadingTargetView(): View? = null


    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}

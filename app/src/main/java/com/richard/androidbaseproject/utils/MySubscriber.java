package com.richard.androidbaseproject.utils;

import android.content.Context;
import com.axl.android.frameworkbase.net.exception.ApiException;
import com.axl.android.frameworkbase.net.utils.ProgressCancelListener;
import com.axl.android.frameworkbase.utils.netstatus.NetUtils;
import com.orhanobut.logger.Logger;
import io.reactivex.subscribers.DisposableSubscriber;

public abstract class MySubscriber<T> extends DisposableSubscriber<T> implements ProgressCancelListener {
    private Context mContext;

    public MySubscriber(Context context) {
        this.mContext = context;
    }


    @Override
    public void onComplete() {}

    @Override
    public void onError(Throwable e) {
        Logger.e("错误："+e.getMessage());
        if (!NetUtils.isNetworkConnected(mContext)) { //这里自行替换判断网络的代码
            _onError( "网络不可用");
        } else if (e instanceof ApiException) {
            _onError(e.getMessage());
        } else {
            _onError("请求失败，请稍后再试...");
        }
    }


    @Override
    public void onNext(T s) {
        _onNext(s);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

    @Override
    public void onCancelProgress() {
        if (!isDisposed()) {
            dispose();
        }
    }
}

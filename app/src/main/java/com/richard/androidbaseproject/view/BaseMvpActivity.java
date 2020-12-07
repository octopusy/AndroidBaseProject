package com.richard.androidbaseproject.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.axl.android.frameworkbase.ui.AbsBaseActivity;
import com.axl.android.frameworkbase.view.statusbar.StatusBarCompat;
import com.richard.androidbaseproject.present.BaseModel;
import com.richard.androidbaseproject.present.BasePersenter;
import com.richard.androidbaseproject.present.IbaseView;
import com.richard.androidbaseproject.utils.TUtil;

/**
 * author : Hank
 * e-mail : cs16xiaoc1@163.com
 * date   : 2019/7/2220:42
 * desc   :
 */
public class BaseMvpActivity<P extends BasePersenter, M extends BaseModel> extends AbsBaseActivity implements IbaseView {
    public P mPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPersenter != null) {
            mPersenter.destory();
        }
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return 0;
    }

    @Override
    protected void initViewsAndEvents() {
        StatusBarCompat.translucentStatusBar(this, true, true);
        setVM();
    }

    private void setVM() {
        mPersenter = TUtil.Companion.getT(this, 0);
        BaseModel mModel = TUtil.Companion.getT(this, 1);
        if (this instanceof IbaseView && mPersenter != null) {
            mPersenter.addView(this, mModel);
        }
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    public Context getContext() {
        return this;
    }
}

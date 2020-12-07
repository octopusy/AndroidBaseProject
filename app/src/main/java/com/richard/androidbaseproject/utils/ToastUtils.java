package com.richard.androidbaseproject.utils;

import android.view.Gravity;
import android.widget.Toast;
import com.richard.androidbaseproject.GlobalApp;

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/5/27
 * Time: 下午5:02
 */

public class ToastUtils {
    public static void showShort(String msg) {
        Toast toast = Toast.makeText(GlobalApp.mContext,msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLong(String msg) {
        Toast toast = Toast.makeText(GlobalApp.mContext,msg,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

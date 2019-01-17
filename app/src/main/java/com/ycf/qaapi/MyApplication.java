package com.ycf.qaapi;

import android.app.Application;
import android.content.ComponentCallbacks;

import com.anupcowkur.reservoir.Reservoir;
import com.ycf.qaapi.tools.LogUtil;

import java.io.IOException;

/* * *
 * created by:   cf.yao
 * on:           2019.一月.16   14:03
 * Des:
 *
 * * */

public class MyApplication extends Application {
    private static final String LOG_TAG = "MyApplication";
    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Reservoir.init(getApplicationContext(), 1048576);
        } catch (IOException e) {
            LogUtil.e(LOG_TAG, "Reservoir初始化缓存文件失败了。", e);
        }

    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }
}

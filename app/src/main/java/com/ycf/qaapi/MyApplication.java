package com.ycf.qaapi;

import android.app.Application;
import android.content.ComponentCallbacks;

/* * *
 * created by:   cf.yao
 * on:           2019.一月.16   14:03
 * Des:
 *
 * * */

public class MyApplication extends Application {
    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }
}

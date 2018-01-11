package com.hss01248.log;

import android.app.Application;

/**
 * Created by huangshuisheng on 2017/12/12.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogTest.init(this);


    }
}

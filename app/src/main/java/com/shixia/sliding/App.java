package com.shixia.sliding;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by Administrator on 2018/9/27.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}

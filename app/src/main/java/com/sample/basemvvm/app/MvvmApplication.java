package com.sample.basemvvm.app;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Administrator on 2019/2/23.
 */

public class MvvmApplication extends MultiDexApplication {

    private static MvvmApplication instance;

    public static MvvmApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //CrashReport.initCrashReport(getApplicationContext(), "3977b2d86f", DebugUtil.DEBUG);
        initTextSize();
    }

    /**
     * 使其系统更改字体大小无效
     */
    private void initTextSize() {
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}

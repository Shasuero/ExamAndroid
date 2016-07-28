package com.apj.apjexam;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

public class MyApplication extends Application {
    final String AV_APP_ID = "XS5dChbFhCFNHAXjc5xJkiOM-gzGzoHsz";
    final String AV_APP_KEY = "kAfwpw25VdutSglo6O5WGiHk";

    @Override
    public void onCreate() {
        super.onCreate();

        AVOSCloud.initialize(this, AV_APP_ID, AV_APP_KEY);
        AVOSCloud.useAVCloudCN();
    }
}

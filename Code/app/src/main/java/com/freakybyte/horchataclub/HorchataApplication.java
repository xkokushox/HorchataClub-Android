package com.freakybyte.horchataclub;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

public class HorchataApplication extends Application {
    private static final String TAG = "BentoApplication";

    private static HorchataApplication mAppInstance;

    public static Application getInstance() {
        return mAppInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppInstance = this;
        Fresco.initialize(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}

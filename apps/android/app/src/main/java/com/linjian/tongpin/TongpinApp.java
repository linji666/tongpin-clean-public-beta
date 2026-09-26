package com.linjian.tongpin;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * 只做一件事：主界面出来之后，把“一起听”那条挂到播放页里。
 */
public final class TongpinApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (!(activity instanceof MainActivity)) return;
                activity.getWindow().getDecorView().post(() -> TogetherRow.attach(activity));
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }
}

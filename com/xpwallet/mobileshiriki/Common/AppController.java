package com.xpwallet.mobileshiriki.Common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class AppController extends MultiDexApplication {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private boolean isAppIsInBackground() {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) getSystemService("activity");
        if (VERSION.SDK_INT > 20) {
            for (RunningAppProcessInfo processInfo : am.getRunningAppProcesses()) {
                if (processInfo.importance == 100) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
            return isInBackground;
        } else if (((RunningTaskInfo) am.getRunningTasks(1).get(0)).topActivity.getPackageName().equals(getPackageName())) {
            return false;
        } else {
            return true;
        }
    }
}

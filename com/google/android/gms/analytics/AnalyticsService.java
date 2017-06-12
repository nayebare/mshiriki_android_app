package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztc.zza;

public final class AnalyticsService extends Service implements zza {
    private zztc zzaap;

    private zztc zzlP() {
        if (this.zzaap == null) {
            this.zzaap = new zztc(this);
        }
        return this.zzaap;
    }

    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public Context getContext() {
        return this;
    }

    public IBinder onBind(Intent intent) {
        zzlP();
        return null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        super.onCreate();
        zzlP().onCreate();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzlP().onDestroy();
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int i, int i2) {
        return zzlP().onStartCommand(intent, i, i2);
    }
}

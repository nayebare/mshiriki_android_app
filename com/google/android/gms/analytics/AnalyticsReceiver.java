package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zztb;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private zztb zzaao;

    private zztb zzlO() {
        if (this.zzaao == null) {
            this.zzaao = new zztb();
        }
        return this.zzaao;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzlO().onReceive(context, intent);
    }
}

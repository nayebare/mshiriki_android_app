package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;

public class zzbkw implements zzbmg {
    private final Handler handler;

    public zzbkw() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void restart() {
    }

    public void shutdown() {
    }

    public void zzq(Runnable runnable) {
        this.handler.post(runnable);
    }
}

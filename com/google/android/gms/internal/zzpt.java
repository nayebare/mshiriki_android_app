package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzpt {
    private long zzXL;
    private long zzXM;
    private Object zzrN;

    public zzpt(long j) {
        this.zzXM = Long.MIN_VALUE;
        this.zzrN = new Object();
        this.zzXL = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzrN) {
            long elapsedRealtime = zzv.zzcP().elapsedRealtime();
            if (this.zzXM + this.zzXL > elapsedRealtime) {
                z = false;
            } else {
                this.zzXM = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}

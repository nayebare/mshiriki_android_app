package com.google.android.gms.internal;

import android.util.Log;

public class zzayj implements zzayy {
    private int zzaeb;
    private boolean zzbHz;

    public zzayj() {
        this.zzbHz = true;
        this.zzaeb = 5;
    }

    public void m21e(String str) {
        if (zzai(6)) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m22v(String str) {
        if (zzai(2)) {
            Log.v("GoogleTagManager", str);
        }
    }

    public boolean zzai(int i) {
        return (this.zzbHz && Log.isLoggable("GoogleTagManager", i)) || (!this.zzbHz && this.zzaeb <= i);
    }

    public void zzb(String str, Throwable th) {
        if (zzai(6)) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzbd(String str) {
        if (zzai(4)) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzbe(String str) {
        if (zzai(5)) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzc(String str, Throwable th) {
        if (zzai(5)) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}

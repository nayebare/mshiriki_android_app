package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.zzi.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public class zzc extends zza {
    private final CastStateListener zzapp;

    public zzc(CastStateListener castStateListener) {
        this.zzapp = castStateListener;
    }

    public void onCastStateChanged(int i) {
        this.zzapp.onCastStateChanged(i);
    }

    public int zzsd() {
        return 10084208;
    }

    public zzd zzse() {
        return zze.zzA(this.zzapp);
    }
}

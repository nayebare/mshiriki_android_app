package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public class zza extends com.google.android.gms.cast.framework.zze.zza {
    private final AppVisibilityListener zzaoP;

    public zza(AppVisibilityListener appVisibilityListener) {
        this.zzaoP = appVisibilityListener;
    }

    public void onAppEnteredBackground() {
        this.zzaoP.onAppEnteredBackground();
    }

    public void onAppEnteredForeground() {
        this.zzaoP.onAppEnteredForeground();
    }

    public int zzsd() {
        return 10084208;
    }

    public zzd zzse() {
        return zze.zzA(this.zzaoP);
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.zzhm.zza;

@zzmb
public class zzhr extends zza {
    private final OnCustomTemplateAdLoadedListener zzHb;

    public zzhr(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzHb = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzhh com_google_android_gms_internal_zzhh) {
        this.zzHb.onCustomTemplateAdLoaded(new zzhi(com_google_android_gms_internal_zzhh));
    }
}

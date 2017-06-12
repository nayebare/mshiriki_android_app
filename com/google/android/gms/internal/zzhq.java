package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.zzhl.zza;

@zzmb
public class zzhq extends zza {
    private final OnCustomClickListener zzHa;

    public zzhq(OnCustomClickListener onCustomClickListener) {
        this.zzHa = onCustomClickListener;
    }

    public void zza(zzhh com_google_android_gms_internal_zzhh, String str) {
        this.zzHa.onCustomClick(new zzhi(com_google_android_gms_internal_zzhh), str);
    }
}

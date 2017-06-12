package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import java.util.concurrent.Future;

@zzmb
public class zziy {
    private zzix zza(Context context, zzqa com_google_android_gms_internal_zzqa, zza<zzix> com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd) {
        zziz com_google_android_gms_internal_zziz = new zziz(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzav, com_google_android_gms_ads_internal_zzd);
        com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix.zzIW = com_google_android_gms_internal_zziz;
        com_google_android_gms_internal_zziz.zza(new 2(this, com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix));
        return com_google_android_gms_internal_zziz;
    }

    public Future<zzix> zza(Context context, zzqa com_google_android_gms_internal_zzqa, String str, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd) {
        zza com_google_android_gms_internal_zziy_zza = new zza(null);
        zzpi.zzWR.post(new 1(this, context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zziy_zza, com_google_android_gms_internal_zzav, com_google_android_gms_ads_internal_zzd, str));
        return com_google_android_gms_internal_zziy_zza;
    }
}

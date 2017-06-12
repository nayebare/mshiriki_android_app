package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzmf.zza;
import com.google.android.gms.internal.zzmf.zzb;

@zzmb
public final class zzme {
    public static zzpk zza(Context context, zzqa com_google_android_gms_internal_zzqa, zzqi<zzmh> com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, zza com_google_android_gms_internal_zzme_zza) {
        return zza(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, com_google_android_gms_internal_zzme_zza, new 1(context));
    }

    static zzpk zza(Context context, zzqa com_google_android_gms_internal_zzqa, zzqi<zzmh> com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, zza com_google_android_gms_internal_zzme_zza, zzb com_google_android_gms_internal_zzme_zzb) {
        return com_google_android_gms_internal_zzme_zzb.zza(com_google_android_gms_internal_zzqa) ? zza(context, com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, com_google_android_gms_internal_zzme_zza) : zzb(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, com_google_android_gms_internal_zzme_zza);
    }

    private static zzpk zza(Context context, zzqi<zzmh> com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, zza com_google_android_gms_internal_zzme_zza) {
        zzpy.zzbc("Fetching ad response from local ad request service.");
        zzpk com_google_android_gms_internal_zzmf_zza = new zza(context, com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, com_google_android_gms_internal_zzme_zza);
        com_google_android_gms_internal_zzmf_zza.zziw();
        return com_google_android_gms_internal_zzmf_zza;
    }

    private static zzpk zzb(Context context, zzqa com_google_android_gms_internal_zzqa, zzqi<zzmh> com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, zza com_google_android_gms_internal_zzme_zza) {
        zzpy.zzbc("Fetching ad response from remote ad request service.");
        if (zzeh.zzeO().zzP(context)) {
            return new zzb(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzqi_com_google_android_gms_internal_zzmh, com_google_android_gms_internal_zzme_zza);
        }
        zzpy.zzbe("Failed to connect to remote ad request service.");
        return null;
    }
}

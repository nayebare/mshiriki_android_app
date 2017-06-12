package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.util.Map;

@zzmb
public class zzpp {
    private static zzl zzXw;
    private static final Object zzXx;
    public static final zza<Void> zzXy;

    static {
        zzXx = new Object();
        zzXy = new 1();
    }

    public zzpp(Context context) {
        zzN(context);
    }

    private static zzl zzN(Context context) {
        zzl com_google_android_gms_internal_zzl;
        synchronized (zzXx) {
            if (zzXw == null) {
                zzXw = zzac.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzl = zzXw;
        }
        return com_google_android_gms_internal_zzl;
    }

    public zzqf<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        zzc com_google_android_gms_internal_zzpp_zzc = new zzc(this, null);
        zzXw.zze(new 3(this, i, str, com_google_android_gms_internal_zzpp_zzc, new 2(this, str, com_google_android_gms_internal_zzpp_zzc), bArr, map));
        return com_google_android_gms_internal_zzpp_zzc;
    }

    public <T> zzqf<T> zza(String str, zza<T> com_google_android_gms_internal_zzpp_zza_T) {
        zzc com_google_android_gms_internal_zzpp_zzc = new zzc(this, null);
        zzXw.zze(new zzb(str, com_google_android_gms_internal_zzpp_zza_T, com_google_android_gms_internal_zzpp_zzc));
        return com_google_android_gms_internal_zzpp_zzc;
    }

    public zzqf<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}

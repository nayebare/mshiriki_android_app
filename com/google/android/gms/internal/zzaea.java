package com.google.android.gms.internal;

import com.google.android.gms.awareness.state.BeaconState.TypeFilter;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbtp.zza;
import com.google.android.gms.internal.zzvr.zzb;

public class zzaea {
    private final zzbtp zzaHN;

    public zzaea(zzbtp com_google_android_gms_internal_zzbtp) {
        this.zzaHN = (zzbtp) zzac.zzw(com_google_android_gms_internal_zzbtp);
    }

    private static zzbtp zza(int i, TypeFilter[] typeFilterArr, long j) {
        zzbtp com_google_android_gms_internal_zzbtp = new zzbtp();
        com_google_android_gms_internal_zzbtp.zzcqk = i;
        if (!(typeFilterArr == null || typeFilterArr.length == 0)) {
            com_google_android_gms_internal_zzbtp.zzcqt = new zza[typeFilterArr.length];
            int i2 = 0;
            for (TypeFilter typeFilter : typeFilterArr) {
                com_google_android_gms_internal_zzbtp.zzcqt[i2] = ((zzb) typeFilter).zzrl();
                i2++;
            }
        }
        com_google_android_gms_internal_zzbtp.zzcql = j;
        return com_google_android_gms_internal_zzbtp;
    }

    public static zzaea zzb(TypeFilter[] typeFilterArr) {
        return new zzaea(zza(1, typeFilterArr, 3000));
    }

    public static zzaea zzc(TypeFilter[] typeFilterArr) {
        return new zzaea(zza(2, typeFilterArr, 3000));
    }

    public static zzaea zzd(TypeFilter[] typeFilterArr) {
        return new zzaea(zza(3, typeFilterArr, 3000));
    }

    public zzbtp zzzm() {
        return this.zzaHN;
    }
}

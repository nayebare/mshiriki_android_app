package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;

public class zzadx {
    private final zzbtn zzaHJ;

    public zzadx(zzbtn com_google_android_gms_internal_zzbtn) {
        this.zzaHJ = (zzbtn) zzac.zzw(com_google_android_gms_internal_zzbtn);
    }

    public static zzadx zza(int i, int[] iArr) {
        boolean z = iArr != null && iArr.length > 0;
        zzac.zzas(z);
        return new zzadx(zza(i, iArr, 3000));
    }

    private static zzbtn zza(int i, int[] iArr, long j) {
        zzbtn com_google_android_gms_internal_zzbtn = new zzbtn();
        com_google_android_gms_internal_zzbtn.zzcqk = i;
        com_google_android_gms_internal_zzbtn.zzcql = j;
        com_google_android_gms_internal_zzbtn.zzcqm = iArr;
        return com_google_android_gms_internal_zzbtn;
    }

    public static zzadx zzb(int[] iArr) {
        return zza(1, iArr);
    }

    public zzbtn zzzi() {
        return this.zzaHJ;
    }
}

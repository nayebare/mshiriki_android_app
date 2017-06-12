package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;

public class zzaer {
    private final zzbtz zzaIe;

    public zzaer(zzbtz com_google_android_gms_internal_zzbtz) {
        this.zzaIe = (zzbtz) zzac.zzw(com_google_android_gms_internal_zzbtz);
    }

    public static zzaer zza(int i, int i2, double d) {
        zzac.zzas(d >= 0.0d);
        return new zzaer(zza(2, 1, i, i2, d, d, 3000, 0));
    }

    public static zzaer zza(int i, int i2, double d, long j) {
        zzac.zzas(d >= 0.0d);
        return new zzaer(zza(1, 1, i, i2, d, d, 0, j));
    }

    private static zzbtz zza(int i, int i2, int i3, int i4, double d, double d2, long j, long j2) {
        zzbtz com_google_android_gms_internal_zzbtz = new zzbtz();
        com_google_android_gms_internal_zzbtz.zzcqk = i;
        com_google_android_gms_internal_zzbtz.zzcrv = i2;
        com_google_android_gms_internal_zzbtz.zzcql = j;
        com_google_android_gms_internal_zzbtz.zzcrA = j2;
        if (i2 == 1) {
            com_google_android_gms_internal_zzbtz.zzcrw = i3;
            com_google_android_gms_internal_zzbtz.zzcrx = i4;
            com_google_android_gms_internal_zzbtz.zzcry = d;
            com_google_android_gms_internal_zzbtz.zzcrz = d2;
        }
        return com_google_android_gms_internal_zzbtz;
    }

    public static zzaer zzb(int i, int i2, double d) {
        zzac.zzas(d >= 0.0d);
        return new zzaer(zza(3, 1, i, i2, d, d, 3000, 0));
    }

    public zzbtz zzzq() {
        return this.zzaIe;
    }
}

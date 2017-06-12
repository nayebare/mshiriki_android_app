package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.util.TimeZone;

public class zzaet {
    private final zzbuj zzaIf;

    public zzaet(zzbuj com_google_android_gms_internal_zzbuj) {
        this.zzaIf = (zzbuj) zzac.zzw(com_google_android_gms_internal_zzbuj);
    }

    public static zzaet zza(int i, TimeZone timeZone, long j, long j2) {
        boolean z = true;
        zzac.zzas(i != 1);
        zzac.zzw(timeZone);
        zzac.zzas(j >= 0);
        zzac.zzas(j <= 86400000);
        zzac.zzas(j2 >= 0);
        zzac.zzas(j2 <= 86400000);
        if (j > j2) {
            z = false;
        }
        zzac.zzas(z);
        return new zzaet(zzb(i, timeZone, j, j2));
    }

    private static zzbuj zzb(int i, TimeZone timeZone, long j, long j2) {
        zzbuj com_google_android_gms_internal_zzbuj = new zzbuj();
        com_google_android_gms_internal_zzbuj.zzcqk = i;
        if (!(timeZone == null || TextUtils.isEmpty(timeZone.getID()))) {
            com_google_android_gms_internal_zzbuj.zzcrJ = timeZone.getID();
        }
        com_google_android_gms_internal_zzbuj.zzaIZ = j;
        com_google_android_gms_internal_zzbuj.zzcrK = j2;
        return com_google_android_gms_internal_zzbuj;
    }

    public static zzaet zze(long j, long j2) {
        boolean z = false;
        zzac.zzas(j >= 0);
        zzac.zzas(j2 >= 0);
        if (j <= j2) {
            z = true;
        }
        zzac.zzas(z);
        return new zzaet(zzb(1, null, j, j2));
    }

    public zzbuj zzzr() {
        return this.zzaIf;
    }
}

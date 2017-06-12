package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzq;

public final class zzahp {
    private static final zzq zzaLZ;

    static {
        zzaLZ = new zzq("GmsDrive");
    }

    public static void zzD(String str, String str2) {
        zzaLZ.zzD(str, str2);
    }

    public static void zzE(String str, String str2) {
        zzaLZ.zzE(str, str2);
    }

    public static void zzF(String str, String str2) {
        zzaLZ.zzF(str, str2);
    }

    public static void zza(Context context, String str, String str2, Throwable th) {
        zzaLZ.zze(str, str2, th);
    }

    public static void zza(String str, Throwable th, String str2) {
        zzaLZ.zzd(str, str2, th);
    }

    public static void zzh(Context context, String str, String str2) {
        zza(context, str, str2, new Throwable());
    }
}

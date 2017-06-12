package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;

public class zzbpi {
    public static zzbpe zzZB() {
        return zzbox.zzZp();
    }

    public static zzbpe zzas(Object obj) {
        zzbpe zzar = zzbpf.zzar(obj);
        if (zzar instanceof zzbpc) {
            zzar = new zzbow(Double.valueOf((double) ((Long) zzar.getValue()).longValue()), zzZB());
        }
        if (zzq(zzar)) {
            return zzar;
        }
        throw new DatabaseException("Invalid Firebase Database priority (must be a string, double, ServerValue, or null)");
    }

    public static boolean zzq(zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzbpe.zzZe().isEmpty() && (com_google_android_gms_internal_zzbpe.isEmpty() || (com_google_android_gms_internal_zzbpe instanceof zzbow) || (com_google_android_gms_internal_zzbpe instanceof zzbpk) || (com_google_android_gms_internal_zzbpe instanceof zzbov));
    }
}

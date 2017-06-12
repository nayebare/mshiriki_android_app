package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class zzboy implements Comparator<zzbpd> {
    public static zzboy zzjc(String str) {
        if (str.equals(".value")) {
            return zzbpl.zzZC();
        }
        if (str.equals(".key")) {
            return zzbpa.zzZw();
        }
        if (!str.equals(".priority")) {
            return new zzbpg(new zzbmj(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public zzbpd zzZq() {
        return zzbpd.zzZx();
    }

    public abstract zzbpd zzZr();

    public abstract String zzZs();

    public int zza(zzbpd com_google_android_gms_internal_zzbpd, zzbpd com_google_android_gms_internal_zzbpd2, boolean z) {
        return z ? compare(com_google_android_gms_internal_zzbpd2, com_google_android_gms_internal_zzbpd) : compare(com_google_android_gms_internal_zzbpd, com_google_android_gms_internal_zzbpd2);
    }

    public boolean zza(zzbpe com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe2) {
        return compare(new zzbpd(zzbos.zzYW(), com_google_android_gms_internal_zzbpe), new zzbpd(zzbos.zzYW(), com_google_android_gms_internal_zzbpe2)) != 0;
    }

    public abstract zzbpd zzg(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe);

    public abstract boolean zzm(zzbpe com_google_android_gms_internal_zzbpe);
}

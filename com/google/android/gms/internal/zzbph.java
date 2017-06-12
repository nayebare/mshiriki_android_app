package com.google.android.gms.internal;

public class zzbph extends zzboy {
    private static final zzbph zzchz;

    static {
        zzchz = new zzbph();
    }

    private zzbph() {
    }

    public static zzbph zzZA() {
        return zzchz;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return zza((zzbpd) obj, (zzbpd) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof zzbph;
    }

    public int hashCode() {
        return 3155577;
    }

    public String toString() {
        return "PriorityIndex";
    }

    public zzbpd zzZr() {
        return zzg(zzbos.zzYX(), zzbpe.zzchu);
    }

    public String zzZs() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    public int zza(zzbpd com_google_android_gms_internal_zzbpd, zzbpd com_google_android_gms_internal_zzbpd2) {
        return zzbpf.zza(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY().zzZe(), com_google_android_gms_internal_zzbpd2.zzZz(), com_google_android_gms_internal_zzbpd2.zzUY().zzZe());
    }

    public zzbpd zzg(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbpd(com_google_android_gms_internal_zzbos, new zzbpk("[PRIORITY-POST]", com_google_android_gms_internal_zzbpe));
    }

    public boolean zzm(zzbpe com_google_android_gms_internal_zzbpe) {
        return !com_google_android_gms_internal_zzbpe.zzZe().isEmpty();
    }
}

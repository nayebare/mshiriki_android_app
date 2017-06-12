package com.google.android.gms.internal;

public class zzbpl extends zzboy {
    private static final zzbpl zzchD;

    static {
        zzchD = new zzbpl();
    }

    private zzbpl() {
    }

    public static zzbpl zzZC() {
        return zzchD;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return zza((zzbpd) obj, (zzbpd) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof zzbpl;
    }

    public int hashCode() {
        return 4;
    }

    public String toString() {
        return "ValueIndex";
    }

    public zzbpd zzZr() {
        return new zzbpd(zzbos.zzYX(), zzbpe.zzchu);
    }

    public String zzZs() {
        return ".value";
    }

    public int zza(zzbpd com_google_android_gms_internal_zzbpd, zzbpd com_google_android_gms_internal_zzbpd2) {
        int compareTo = com_google_android_gms_internal_zzbpd.zzUY().compareTo(com_google_android_gms_internal_zzbpd2.zzUY());
        return compareTo == 0 ? com_google_android_gms_internal_zzbpd.zzZz().zzi(com_google_android_gms_internal_zzbpd2.zzZz()) : compareTo;
    }

    public zzbpd zzg(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
    }

    public boolean zzm(zzbpe com_google_android_gms_internal_zzbpe) {
        return true;
    }
}

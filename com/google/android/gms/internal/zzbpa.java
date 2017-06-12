package com.google.android.gms.internal;

public class zzbpa extends zzboy {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbpa zzchl;

    static {
        $assertionsDisabled = !zzbpa.class.desiredAssertionStatus();
        zzchl = new zzbpa();
    }

    private zzbpa() {
    }

    public static zzbpa zzZw() {
        return zzchl;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return zza((zzbpd) obj, (zzbpd) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof zzbpa;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }

    public zzbpd zzZr() {
        return zzbpd.zzZy();
    }

    public String zzZs() {
        return ".key";
    }

    public int zza(zzbpd com_google_android_gms_internal_zzbpd, zzbpd com_google_android_gms_internal_zzbpd2) {
        return com_google_android_gms_internal_zzbpd.zzZz().zzi(com_google_android_gms_internal_zzbpd2.zzZz());
    }

    public zzbpd zzg(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        if ($assertionsDisabled || (com_google_android_gms_internal_zzbpe instanceof zzbpk)) {
            return new zzbpd(zzbos.zzjb((String) com_google_android_gms_internal_zzbpe.getValue()), zzbox.zzZp());
        }
        throw new AssertionError();
    }

    public boolean zzm(zzbpe com_google_android_gms_internal_zzbpe) {
        return true;
    }
}

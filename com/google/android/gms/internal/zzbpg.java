package com.google.android.gms.internal;

public class zzbpg extends zzboy {
    private final zzbmj zzchy;

    public zzbpg(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.size() == 1 && com_google_android_gms_internal_zzbmj.zzXi().zzZa()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.zzchy = com_google_android_gms_internal_zzbmj;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return zza((zzbpd) obj, (zzbpd) obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzchy.equals(((zzbpg) obj).zzchy);
    }

    public int hashCode() {
        return this.zzchy.hashCode();
    }

    public zzbpd zzZr() {
        return new zzbpd(zzbos.zzYX(), zzbox.zzZp().zzl(this.zzchy, zzbpe.zzchu));
    }

    public String zzZs() {
        return this.zzchy.zzXg();
    }

    public int zza(zzbpd com_google_android_gms_internal_zzbpd, zzbpd com_google_android_gms_internal_zzbpd2) {
        int compareTo = com_google_android_gms_internal_zzbpd.zzUY().zzO(this.zzchy).compareTo(com_google_android_gms_internal_zzbpd2.zzUY().zzO(this.zzchy));
        return compareTo == 0 ? com_google_android_gms_internal_zzbpd.zzZz().zzi(com_google_android_gms_internal_zzbpd2.zzZz()) : compareTo;
    }

    public zzbpd zzg(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbpd(com_google_android_gms_internal_zzbos, zzbox.zzZp().zzl(this.zzchy, com_google_android_gms_internal_zzbpe));
    }

    public boolean zzm(zzbpe com_google_android_gms_internal_zzbpe) {
        return !com_google_android_gms_internal_zzbpe.zzO(this.zzchy).isEmpty();
    }
}

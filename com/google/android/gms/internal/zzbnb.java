package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class zzbnb {
    private final zzbmj zzcev;
    private final zzbna zzcew;

    public zzbnb(zzbmj com_google_android_gms_internal_zzbmj, zzbna com_google_android_gms_internal_zzbna) {
        this.zzcev = com_google_android_gms_internal_zzbmj;
        this.zzcew = com_google_android_gms_internal_zzbna;
    }

    public zzbpd zza(zzbpe com_google_android_gms_internal_zzbpe, zzbpd com_google_android_gms_internal_zzbpd, boolean z, zzboy com_google_android_gms_internal_zzboy) {
        return this.zzcew.zza(this.zzcev, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzbpd, z, com_google_android_gms_internal_zzboy);
    }

    public zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe2) {
        return this.zzcew.zza(this.zzcev, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzbpe2);
    }

    public zzbpe zza(zzbos com_google_android_gms_internal_zzbos, zzbnw com_google_android_gms_internal_zzbnw) {
        return this.zzcew.zza(this.zzcev, com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbnw);
    }

    public zzbpe zza(zzbpe com_google_android_gms_internal_zzbpe, List<Long> list) {
        return zza(com_google_android_gms_internal_zzbpe, (List) list, false);
    }

    public zzbpe zza(zzbpe com_google_android_gms_internal_zzbpe, List<Long> list, boolean z) {
        return this.zzcew.zza(this.zzcev, com_google_android_gms_internal_zzbpe, (List) list, z);
    }

    public zzbnb zzb(zzbos com_google_android_gms_internal_zzbos) {
        return new zzbnb(this.zzcev.zza(com_google_android_gms_internal_zzbos), this.zzcew);
    }

    public zzbpe zzc(zzbpe com_google_android_gms_internal_zzbpe) {
        return zza(com_google_android_gms_internal_zzbpe, Collections.emptyList());
    }

    public zzbpe zzd(zzbpe com_google_android_gms_internal_zzbpe) {
        return this.zzcew.zzj(this.zzcev, com_google_android_gms_internal_zzbpe);
    }

    public zzbpe zzv(zzbmj com_google_android_gms_internal_zzbmj) {
        return this.zzcew.zzv(this.zzcev.zzh(com_google_android_gms_internal_zzbmj));
    }
}

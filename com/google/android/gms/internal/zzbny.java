package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;

public class zzbny {
    private final zzboz zzcfB;
    private final zza zzcfG;
    private final zzboz zzcfH;
    private final zzbos zzcfI;
    private final zzbos zzcfJ;

    private zzbny(zza com_google_android_gms_internal_zzboa_zza, zzboz com_google_android_gms_internal_zzboz, zzbos com_google_android_gms_internal_zzbos, zzbos com_google_android_gms_internal_zzbos2, zzboz com_google_android_gms_internal_zzboz2) {
        this.zzcfG = com_google_android_gms_internal_zzboa_zza;
        this.zzcfB = com_google_android_gms_internal_zzboz;
        this.zzcfI = com_google_android_gms_internal_zzbos;
        this.zzcfJ = com_google_android_gms_internal_zzbos2;
        this.zzcfH = com_google_android_gms_internal_zzboz2;
    }

    public static zzbny zza(zzbos com_google_android_gms_internal_zzbos, zzboz com_google_android_gms_internal_zzboz) {
        return new zzbny(zza.CHILD_ADDED, com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, null, null);
    }

    public static zzbny zza(zzbos com_google_android_gms_internal_zzbos, zzboz com_google_android_gms_internal_zzboz, zzboz com_google_android_gms_internal_zzboz2) {
        return new zzbny(zza.CHILD_CHANGED, com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, null, com_google_android_gms_internal_zzboz2);
    }

    public static zzbny zza(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe2) {
        return zza(com_google_android_gms_internal_zzbos, zzboz.zzn(com_google_android_gms_internal_zzbpe), zzboz.zzn(com_google_android_gms_internal_zzbpe2));
    }

    public static zzbny zza(zzboz com_google_android_gms_internal_zzboz) {
        return new zzbny(zza.VALUE, com_google_android_gms_internal_zzboz, null, null, null);
    }

    public static zzbny zzb(zzbos com_google_android_gms_internal_zzbos, zzboz com_google_android_gms_internal_zzboz) {
        return new zzbny(zza.CHILD_REMOVED, com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, null, null);
    }

    public static zzbny zzc(zzbos com_google_android_gms_internal_zzbos, zzboz com_google_android_gms_internal_zzboz) {
        return new zzbny(zza.CHILD_MOVED, com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, null, null);
    }

    public static zzbny zzc(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return zza(com_google_android_gms_internal_zzbos, zzboz.zzn(com_google_android_gms_internal_zzbpe));
    }

    public static zzbny zzd(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return zzb(com_google_android_gms_internal_zzbos, zzboz.zzn(com_google_android_gms_internal_zzbpe));
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzcfG);
        String valueOf2 = String.valueOf(this.zzcfI);
        return new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(" ").append(valueOf2).toString();
    }

    public zzboz zzYi() {
        return this.zzcfB;
    }

    public zzbos zzYk() {
        return this.zzcfI;
    }

    public zza zzYl() {
        return this.zzcfG;
    }

    public zzbos zzYm() {
        return this.zzcfJ;
    }

    public zzboz zzYn() {
        return this.zzcfH;
    }

    public zzbny zzg(zzbos com_google_android_gms_internal_zzbos) {
        return new zzbny(this.zzcfG, this.zzcfB, this.zzcfI, com_google_android_gms_internal_zzbos, this.zzcfH);
    }
}

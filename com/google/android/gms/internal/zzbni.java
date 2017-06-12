package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbng.zza;

public class zzbni extends zzbng {
    private final zzbpe zzceR;

    public zzbni(zzbnh com_google_android_gms_internal_zzbnh, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        super(zza.Overwrite, com_google_android_gms_internal_zzbnh, com_google_android_gms_internal_zzbmj);
        this.zzceR = com_google_android_gms_internal_zzbpe;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", new Object[]{zzVc(), zzXO(), this.zzceR});
    }

    public zzbpe zzXU() {
        return this.zzceR;
    }

    public zzbng zzc(zzbos com_google_android_gms_internal_zzbos) {
        return this.zzbXY.isEmpty() ? new zzbni(this.zzceD, zzbmj.zzXf(), this.zzceR.zzm(com_google_android_gms_internal_zzbos)) : new zzbni(this.zzceD, this.zzbXY.zzXj(), this.zzceR);
    }
}

package com.google.android.gms.internal;

public abstract class zzbng {
    protected final zzbmj zzbXY;
    protected final zza zzceC;
    protected final zzbnh zzceD;

    public enum zza {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    protected zzbng(zza com_google_android_gms_internal_zzbng_zza, zzbnh com_google_android_gms_internal_zzbnh, zzbmj com_google_android_gms_internal_zzbmj) {
        this.zzceC = com_google_android_gms_internal_zzbng_zza;
        this.zzceD = com_google_android_gms_internal_zzbnh;
        this.zzbXY = com_google_android_gms_internal_zzbmj;
    }

    public zzbmj zzVc() {
        return this.zzbXY;
    }

    public zzbnh zzXO() {
        return this.zzceD;
    }

    public zza zzXP() {
        return this.zzceC;
    }

    public abstract zzbng zzc(zzbos com_google_android_gms_internal_zzbos);
}

package com.google.android.gms.internal;

public class zzbnw {
    private final zzboz zzcfB;
    private final boolean zzcfC;
    private final boolean zzcfD;

    public zzbnw(zzboz com_google_android_gms_internal_zzboz, boolean z, boolean z2) {
        this.zzcfB = com_google_android_gms_internal_zzboz;
        this.zzcfC = z;
        this.zzcfD = z2;
    }

    public boolean zzM(zzbmj com_google_android_gms_internal_zzbmj) {
        return com_google_android_gms_internal_zzbmj.isEmpty() ? zzYg() && !this.zzcfD : zzf(com_google_android_gms_internal_zzbmj.zzXi());
    }

    public zzbpe zzUY() {
        return this.zzcfB.zzUY();
    }

    public boolean zzYg() {
        return this.zzcfC;
    }

    public boolean zzYh() {
        return this.zzcfD;
    }

    public zzboz zzYi() {
        return this.zzcfB;
    }

    public boolean zzf(zzbos com_google_android_gms_internal_zzbos) {
        return (zzYg() && !this.zzcfD) || this.zzcfB.zzUY().zzk(com_google_android_gms_internal_zzbos);
    }
}

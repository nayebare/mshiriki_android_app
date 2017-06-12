package com.google.android.gms.internal;

public class zzbog {
    private final zzbnw zzcgp;
    private final zzbnw zzcgq;

    public zzbog(zzbnw com_google_android_gms_internal_zzbnw, zzbnw com_google_android_gms_internal_zzbnw2) {
        this.zzcgp = com_google_android_gms_internal_zzbnw;
        this.zzcgq = com_google_android_gms_internal_zzbnw2;
    }

    public zzbnw zzYK() {
        return this.zzcgp;
    }

    public zzbpe zzYL() {
        return this.zzcgp.zzYg() ? this.zzcgp.zzUY() : null;
    }

    public zzbnw zzYM() {
        return this.zzcgq;
    }

    public zzbpe zzYN() {
        return this.zzcgq.zzYg() ? this.zzcgq.zzUY() : null;
    }

    public zzbog zza(zzboz com_google_android_gms_internal_zzboz, boolean z, boolean z2) {
        return new zzbog(new zzbnw(com_google_android_gms_internal_zzboz, z, z2), this.zzcgq);
    }

    public zzbog zzb(zzboz com_google_android_gms_internal_zzboz, boolean z, boolean z2) {
        return new zzbog(this.zzcgp, new zzbnw(com_google_android_gms_internal_zzboz, z, z2));
    }
}

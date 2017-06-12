package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbng.zza;

public class zzbnf extends zzbng {
    private final zzbma zzceB;

    public zzbnf(zzbnh com_google_android_gms_internal_zzbnh, zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        super(zza.Merge, com_google_android_gms_internal_zzbnh, com_google_android_gms_internal_zzbmj);
        this.zzceB = com_google_android_gms_internal_zzbma;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{zzVc(), zzXO(), this.zzceB});
    }

    public zzbma zzXN() {
        return this.zzceB;
    }

    public zzbng zzc(zzbos com_google_android_gms_internal_zzbos) {
        if (!this.zzbXY.isEmpty()) {
            return this.zzbXY.zzXi().equals(com_google_android_gms_internal_zzbos) ? new zzbnf(this.zzceD, this.zzbXY.zzXj(), this.zzceB) : null;
        } else {
            zzbma zzg = this.zzceB.zzg(new zzbmj(com_google_android_gms_internal_zzbos));
            return zzg.isEmpty() ? null : zzg.zzWF() != null ? new zzbni(this.zzceD, zzbmj.zzXf(), zzg.zzWF()) : new zzbnf(this.zzceD, zzbmj.zzXf(), zzg);
        }
    }
}

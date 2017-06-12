package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbng.zza;

public class zzbnd extends zzbng {
    private final zzbns<Boolean> zzceA;
    private final boolean zzcez;

    public zzbnd(zzbmj com_google_android_gms_internal_zzbmj, zzbns<Boolean> com_google_android_gms_internal_zzbns_java_lang_Boolean, boolean z) {
        super(zza.AckUserWrite, zzbnh.zzceJ, com_google_android_gms_internal_zzbmj);
        this.zzceA = com_google_android_gms_internal_zzbns_java_lang_Boolean;
        this.zzcez = z;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", new Object[]{zzVc(), Boolean.valueOf(this.zzcez), this.zzceA});
    }

    public zzbns<Boolean> zzXL() {
        return this.zzceA;
    }

    public boolean zzXM() {
        return this.zzcez;
    }

    public zzbng zzc(zzbos com_google_android_gms_internal_zzbos) {
        if (!this.zzbXY.isEmpty()) {
            zzbqg.zzb(this.zzbXY.zzXi().equals(com_google_android_gms_internal_zzbos), "operationForChild called for unrelated child.");
            return new zzbnd(this.zzbXY.zzXj(), this.zzceA, this.zzcez);
        } else if (this.zzceA.getValue() != null) {
            zzbqg.zzb(this.zzceA.zzYe().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new zzbnd(zzbmj.zzXf(), this.zzceA.zzI(new zzbmj(com_google_android_gms_internal_zzbos)), this.zzcez);
        }
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbng.zza;

public class zzbne extends zzbng {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !zzbne.class.desiredAssertionStatus();
    }

    public zzbne(zzbnh com_google_android_gms_internal_zzbnh, zzbmj com_google_android_gms_internal_zzbmj) {
        super(zza.ListenComplete, com_google_android_gms_internal_zzbnh, com_google_android_gms_internal_zzbmj);
        if (!$assertionsDisabled && com_google_android_gms_internal_zzbnh.zzXQ()) {
            throw new AssertionError("Can't have a listen complete from a user source");
        }
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", new Object[]{zzVc(), zzXO()});
    }

    public zzbng zzc(zzbos com_google_android_gms_internal_zzbos) {
        return this.zzbXY.isEmpty() ? new zzbne(this.zzceD, zzbmj.zzXf()) : new zzbne(this.zzceD, this.zzbXY.zzXj());
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzboi {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Map<zzbos, zzbny> zzcgw;

    static {
        $assertionsDisabled = !zzboi.class.desiredAssertionStatus();
    }

    public zzboi() {
        this.zzcgw = new HashMap();
    }

    public List<zzbny> zzYO() {
        return new ArrayList(this.zzcgw.values());
    }

    public void zza(zzbny com_google_android_gms_internal_zzbny) {
        zza zzYl = com_google_android_gms_internal_zzbny.zzYl();
        zzbos zzYk = com_google_android_gms_internal_zzbny.zzYk();
        if (!$assertionsDisabled && zzYl != zza.CHILD_ADDED && zzYl != zza.CHILD_CHANGED && zzYl != zza.CHILD_REMOVED) {
            throw new AssertionError("Only child changes supported for tracking");
        } else if (!$assertionsDisabled && com_google_android_gms_internal_zzbny.zzYk().zzZa()) {
            throw new AssertionError();
        } else if (this.zzcgw.containsKey(zzYk)) {
            zzbny com_google_android_gms_internal_zzbny2 = (zzbny) this.zzcgw.get(zzYk);
            zza zzYl2 = com_google_android_gms_internal_zzbny2.zzYl();
            if (zzYl == zza.CHILD_ADDED && zzYl2 == zza.CHILD_REMOVED) {
                this.zzcgw.put(com_google_android_gms_internal_zzbny.zzYk(), zzbny.zza(zzYk, com_google_android_gms_internal_zzbny.zzYi(), com_google_android_gms_internal_zzbny2.zzYi()));
            } else if (zzYl == zza.CHILD_REMOVED && zzYl2 == zza.CHILD_ADDED) {
                this.zzcgw.remove(zzYk);
            } else if (zzYl == zza.CHILD_REMOVED && zzYl2 == zza.CHILD_CHANGED) {
                this.zzcgw.put(zzYk, zzbny.zzb(zzYk, com_google_android_gms_internal_zzbny2.zzYn()));
            } else if (zzYl == zza.CHILD_CHANGED && zzYl2 == zza.CHILD_ADDED) {
                this.zzcgw.put(zzYk, zzbny.zza(zzYk, com_google_android_gms_internal_zzbny.zzYi()));
            } else if (zzYl == zza.CHILD_CHANGED && zzYl2 == zza.CHILD_CHANGED) {
                this.zzcgw.put(zzYk, zzbny.zza(zzYk, com_google_android_gms_internal_zzbny.zzYi(), com_google_android_gms_internal_zzbny2.zzYn()));
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzbny);
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbny2);
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 48) + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        } else {
            this.zzcgw.put(com_google_android_gms_internal_zzbny.zzYk(), com_google_android_gms_internal_zzbny);
        }
    }
}

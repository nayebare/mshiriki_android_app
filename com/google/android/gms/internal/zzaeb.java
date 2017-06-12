package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

public class zzaeb extends com.google.android.gms.internal.zzaeq.zza {
    public static final com.google.android.gms.internal.zzcg.zza<com.google.android.gms.awareness.fence.zza, zzaeb> zzaHO;
    private final Handler mHandler;
    private final com.google.android.gms.awareness.fence.zza zzaHP;

    /* renamed from: com.google.android.gms.internal.zzaeb.1 */
    class C09161 implements com.google.android.gms.internal.zzcg.zza<com.google.android.gms.awareness.fence.zza, zzaeb> {
        C09161() {
        }

        public zzaeb zza(com.google.android.gms.awareness.fence.zza com_google_android_gms_awareness_fence_zza, Looper looper) {
            return new zzaeb(looper, null);
        }
    }

    private static class zza implements Runnable {
        private final com.google.android.gms.awareness.fence.zza zzaHP;
        private final zzaem zzaHQ;

        public zza(com.google.android.gms.awareness.fence.zza com_google_android_gms_awareness_fence_zza, zzaem com_google_android_gms_internal_zzaem) {
            this.zzaHP = (com.google.android.gms.awareness.fence.zza) zzac.zzw(com_google_android_gms_awareness_fence_zza);
            this.zzaHQ = (zzaem) zzac.zzw(com_google_android_gms_internal_zzaem);
        }

        public void run() {
            String str = this.zzaHQ.zzaA;
            boolean z = this.zzaHQ.zzaIc;
        }
    }

    static {
        zzaHO = new C09161();
    }

    private zzaeb(com.google.android.gms.awareness.fence.zza com_google_android_gms_awareness_fence_zza, Looper looper) {
        this.zzaHP = (com.google.android.gms.awareness.fence.zza) zzac.zzw(com_google_android_gms_awareness_fence_zza);
        this.mHandler = zzafa.zza((Looper) zzac.zzw(looper));
    }

    public void zza(zzaem com_google_android_gms_internal_zzaem) {
        this.mHandler.post(new zza(this.zzaHP, com_google_android_gms_internal_zzaem));
    }
}

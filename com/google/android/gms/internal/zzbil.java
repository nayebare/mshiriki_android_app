package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

public abstract class zzbil {
    private static final ThreadLocal<zzbil> zzbTZ;

    public static abstract class zza {
        private Runnable zzbUa;
        private FrameCallback zzbUb;

        /* renamed from: com.google.android.gms.internal.zzbil.zza.1 */
        class C11721 implements FrameCallback {
            final /* synthetic */ zza zzbUc;

            C11721(zza com_google_android_gms_internal_zzbil_zza) {
                this.zzbUc = com_google_android_gms_internal_zzbil_zza;
            }

            public void doFrame(long j) {
                this.zzbUc.doFrame(j);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzbil.zza.2 */
        class C11732 implements Runnable {
            final /* synthetic */ zza zzbUc;

            C11732(zza com_google_android_gms_internal_zzbil_zza) {
                this.zzbUc = com_google_android_gms_internal_zzbil_zza;
            }

            public void run() {
                this.zzbUc.doFrame(System.nanoTime());
            }
        }

        public abstract void doFrame(long j);

        @TargetApi(16)
        FrameCallback zzTi() {
            if (this.zzbUb == null) {
                this.zzbUb = new C11721(this);
            }
            return this.zzbUb;
        }

        Runnable zzTj() {
            if (this.zzbUa == null) {
                this.zzbUa = new C11732(this);
            }
            return this.zzbUa;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbil.1 */
    class C11711 extends ThreadLocal<zzbil> {
        C11711() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzTh();
        }

        protected zzbil zzTh() {
            if (VERSION.SDK_INT >= 16) {
                return new zzc();
            }
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                return new zzb(myLooper);
            }
            throw new IllegalStateException("The current thread must have a looper!");
        }
    }

    private static class zzb extends zzbil {
        private Handler handler;

        public zzb(Looper looper) {
            this.handler = new Handler(looper);
        }

        public void zza(zza com_google_android_gms_internal_zzbil_zza) {
            this.handler.postDelayed(com_google_android_gms_internal_zzbil_zza.zzTj(), 0);
        }
    }

    @TargetApi(16)
    private static class zzc extends zzbil {
        private Choreographer zzbUd;

        public zzc() {
            this.zzbUd = Choreographer.getInstance();
        }

        public void zza(zza com_google_android_gms_internal_zzbil_zza) {
            this.zzbUd.postFrameCallback(com_google_android_gms_internal_zzbil_zza.zzTi());
        }
    }

    static {
        zzbTZ = new C11711();
    }

    public static zzbil zzTg() {
        return (zzbil) zzbTZ.get();
    }

    public abstract void zza(zza com_google_android_gms_internal_zzbil_zza);
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzazj extends zzazi {
    private static final Object zzbFZ;
    private static zzazj zzbIB;
    private boolean connected;
    private Context zzbGa;
    private int zzbGd;
    private boolean zzbGe;
    private boolean zzbGf;
    private boolean zzbGg;
    private boolean zzbGk;
    private zzayz zzbIA;
    private zzays zzbIv;
    private volatile zzayq zzbIw;
    private boolean zzbIx;
    private zzayt zzbIy;
    private zza zzbIz;

    /* renamed from: com.google.android.gms.internal.zzazj.1 */
    class C11191 implements zzayt {
        final /* synthetic */ zzazj zzbIC;

        C11191(zzazj com_google_android_gms_internal_zzazj) {
            this.zzbIC = com_google_android_gms_internal_zzazj;
        }

        public void zzaM(boolean z) {
            this.zzbIC.zze(z, this.zzbIC.connected);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazj.2 */
    class C11202 implements Runnable {
        final /* synthetic */ zzazj zzbIC;

        C11202(zzazj com_google_android_gms_internal_zzazj) {
            this.zzbIC = com_google_android_gms_internal_zzazj;
        }

        public void run() {
            this.zzbIC.zzbIx = false;
            this.zzbIC.zzbIv.dispatch();
        }
    }

    public interface zza {
        void cancel();

        void zzPY();

        void zzx(long j);
    }

    private class zzb implements zza {
        private Handler handler;
        final /* synthetic */ zzazj zzbIC;

        /* renamed from: com.google.android.gms.internal.zzazj.zzb.1 */
        class C11211 implements Callback {
            final /* synthetic */ zzb zzbID;

            C11211(zzb com_google_android_gms_internal_zzazj_zzb) {
                this.zzbID = com_google_android_gms_internal_zzazj_zzb;
            }

            public boolean handleMessage(Message message) {
                if (1 == message.what && zzazj.zzbFZ.equals(message.obj)) {
                    this.zzbID.zzbIC.dispatch();
                    if (!this.zzbID.zzbIC.isPowerSaveMode()) {
                        this.zzbID.zzx((long) this.zzbID.zzbIC.zzbGd);
                    }
                }
                return true;
            }
        }

        private zzb(zzazj com_google_android_gms_internal_zzazj) {
            this.zzbIC = com_google_android_gms_internal_zzazj;
            this.handler = new Handler(this.zzbIC.zzbGa.getMainLooper(), new C11211(this));
        }

        private Message obtainMessage() {
            return this.handler.obtainMessage(1, zzazj.zzbFZ);
        }

        public void cancel() {
            this.handler.removeMessages(1, zzazj.zzbFZ);
        }

        public void zzPY() {
            this.handler.removeMessages(1, zzazj.zzbFZ);
            this.handler.sendMessage(obtainMessage());
        }

        public void zzx(long j) {
            this.handler.removeMessages(1, zzazj.zzbFZ);
            this.handler.sendMessageDelayed(obtainMessage(), j);
        }
    }

    static {
        zzbFZ = new Object();
    }

    private zzazj() {
        this.zzbGd = 1800000;
        this.zzbGe = true;
        this.zzbGf = false;
        this.zzbIx = false;
        this.connected = true;
        this.zzbGg = true;
        this.zzbIy = new C11191(this);
        this.zzbGk = false;
    }

    private boolean isPowerSaveMode() {
        return this.zzbGk || !this.connected || this.zzbGd <= 0;
    }

    private void zzPU() {
        this.zzbIA = new zzayz(this);
        this.zzbIA.zzbJ(this.zzbGa);
    }

    private void zzPV() {
        this.zzbIz = new zzb();
        if (this.zzbGd > 0) {
            this.zzbIz.zzx((long) this.zzbGd);
        }
    }

    public static zzazj zzQM() {
        if (zzbIB == null) {
            zzbIB = new zzazj();
        }
        return zzbIB;
    }

    private void zzog() {
        if (isPowerSaveMode()) {
            this.zzbIz.cancel();
            zzayx.m24v("PowerSaveMode initiated.");
            return;
        }
        this.zzbIz.zzx((long) this.zzbGd);
        zzayx.m24v("PowerSaveMode terminated.");
    }

    public synchronized void dispatch() {
        if (!this.zzbGf) {
            zzayx.m24v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbGe = true;
        } else if (!this.zzbIx) {
            this.zzbIx = true;
            this.zzbIw.zzp(new C11202(this));
        }
    }

    synchronized zzays zzQN() {
        if (this.zzbIv == null) {
            if (this.zzbGa == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzbIv = new zzaza(this.zzbIy, this.zzbGa);
        }
        if (this.zzbIz == null) {
            zzPV();
        }
        this.zzbGf = true;
        if (this.zzbGe) {
            dispatch();
            this.zzbGe = false;
        }
        if (this.zzbIA == null && this.zzbGg) {
            zzPU();
        }
        return this.zzbIv;
    }

    synchronized void zza(Context context, zzayq com_google_android_gms_internal_zzayq) {
        if (this.zzbGa == null) {
            this.zzbGa = context.getApplicationContext();
            if (this.zzbIw == null) {
                this.zzbIw = com_google_android_gms_internal_zzayq;
            }
        }
    }

    public synchronized void zzaN(boolean z) {
        zze(this.zzbGk, z);
    }

    synchronized void zze(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzbGk = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            zzog();
        }
    }

    public synchronized void zznn() {
        if (!isPowerSaveMode()) {
            this.zzbIz.zzPY();
        }
    }
}

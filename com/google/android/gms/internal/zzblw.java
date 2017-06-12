package com.google.android.gms.internal;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzblw {
    private final ScheduledExecutorService zzbYl;
    private final zzbop zzbYx;
    private final long zzcbh;
    private final long zzcbi;
    private final double zzcbj;
    private final double zzcbk;
    private final Random zzcbl;
    private ScheduledFuture<?> zzcbm;
    private long zzcbn;
    private boolean zzcbo;

    /* renamed from: com.google.android.gms.internal.zzblw.1 */
    class C12051 implements Runnable {
        final /* synthetic */ Runnable zzaqm;
        final /* synthetic */ zzblw zzcbp;

        C12051(zzblw com_google_android_gms_internal_zzblw, Runnable runnable) {
            this.zzcbp = com_google_android_gms_internal_zzblw;
            this.zzaqm = runnable;
        }

        public void run() {
            this.zzcbp.zzcbm = null;
            this.zzaqm.run();
        }
    }

    public static class zza {
        private final zzbop zzbYx;
        private long zzcbh;
        private double zzcbj;
        private double zzcbk;
        private final ScheduledExecutorService zzcbq;
        private long zzcbr;

        public zza(ScheduledExecutorService scheduledExecutorService, zzboq com_google_android_gms_internal_zzboq, String str) {
            this.zzcbh = 1000;
            this.zzcbj = 0.5d;
            this.zzcbr = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
            this.zzcbk = 1.3d;
            this.zzcbq = scheduledExecutorService;
            this.zzbYx = new zzbop(com_google_android_gms_internal_zzboq, str);
        }

        public zzblw zzWy() {
            return new zzblw(this.zzbYx, this.zzcbh, this.zzcbr, this.zzcbk, this.zzcbj, null);
        }

        public zza zzaI(long j) {
            this.zzcbh = j;
            return this;
        }

        public zza zzaJ(long j) {
            this.zzcbr = j;
            return this;
        }

        public zza zzj(double d) {
            this.zzcbk = d;
            return this;
        }

        public zza zzk(double d) {
            if (d < 0.0d || d > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d);
            }
            this.zzcbj = d;
            return this;
        }
    }

    private zzblw(ScheduledExecutorService scheduledExecutorService, zzbop com_google_android_gms_internal_zzbop, long j, long j2, double d, double d2) {
        this.zzcbl = new Random();
        this.zzcbo = true;
        this.zzbYl = scheduledExecutorService;
        this.zzbYx = com_google_android_gms_internal_zzbop;
        this.zzcbh = j;
        this.zzcbi = j2;
        this.zzcbk = d;
        this.zzcbj = d2;
    }

    public void cancel() {
        if (this.zzcbm != null) {
            this.zzbYx.zzi("Cancelling existing retry attempt", new Object[0]);
            this.zzcbm.cancel(false);
            this.zzcbm = null;
        } else {
            this.zzbYx.zzi("No existing retry attempt to cancel", new Object[0]);
        }
        this.zzcbn = 0;
    }

    public void zzUk() {
        this.zzcbo = true;
        this.zzcbn = 0;
    }

    public void zzWx() {
        this.zzcbn = this.zzcbi;
    }

    public void zzr(Runnable runnable) {
        long j = 0;
        Runnable c12051 = new C12051(this, runnable);
        if (this.zzcbm != null) {
            this.zzbYx.zzi("Cancelling previous scheduled retry", new Object[0]);
            this.zzcbm.cancel(false);
            this.zzcbm = null;
        }
        if (!this.zzcbo) {
            if (this.zzcbn == 0) {
                this.zzcbn = this.zzcbh;
            } else {
                this.zzcbn = Math.min((long) (((double) this.zzcbn) * this.zzcbk), this.zzcbi);
            }
            j = (long) (((1.0d - this.zzcbj) * ((double) this.zzcbn)) + ((this.zzcbj * ((double) this.zzcbn)) * this.zzcbl.nextDouble()));
        }
        this.zzcbo = false;
        this.zzbYx.zzi("Scheduling retry in %dms", Long.valueOf(j));
        this.zzcbm = this.zzbYl.schedule(c12051, j, TimeUnit.MILLISECONDS);
    }
}

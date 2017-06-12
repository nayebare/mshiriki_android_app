package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzov.zza;

@zzmb
public class zzoa extends zzpd implements zzoc, zzof {
    private final Context mContext;
    private final String zzKo;
    private int zzPF;
    private final zza zzPo;
    private final zzoh zzUL;
    private final zzof zzUM;
    private final String zzUN;
    private final zzji zzUO;
    private final long zzUP;
    private int zzUQ;
    private zzob zzUR;
    private final Object zzrN;

    public zzoa(Context context, String str, String str2, zzji com_google_android_gms_internal_zzji, zza com_google_android_gms_internal_zzov_zza, zzoh com_google_android_gms_internal_zzoh, zzof com_google_android_gms_internal_zzof, long j) {
        this.zzUQ = 0;
        this.zzPF = 3;
        this.mContext = context;
        this.zzKo = str;
        this.zzUN = str2;
        this.zzUO = com_google_android_gms_internal_zzji;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzUL = com_google_android_gms_internal_zzoh;
        this.zzrN = new Object();
        this.zzUM = com_google_android_gms_internal_zzof;
        this.zzUP = j;
    }

    private void zza(zzdy com_google_android_gms_internal_zzdy, zzjt com_google_android_gms_internal_zzjt) {
        this.zzUL.zzjx().zza((zzof) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzKo)) {
                com_google_android_gms_internal_zzjt.zza(com_google_android_gms_internal_zzdy, this.zzUN, this.zzUO.zzJG);
            } else {
                com_google_android_gms_internal_zzjt.zzc(com_google_android_gms_internal_zzdy, this.zzUN);
            }
        } catch (Throwable e) {
            zzpy.zzc("Fail to load ad from adapter.", e);
            zza(this.zzKo, 0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzk(long r6) {
        /*
        r5 = this;
    L_0x0000:
        r1 = r5.zzrN;
        monitor-enter(r1);
        r0 = r5.zzUQ;	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x003c;
    L_0x0007:
        r0 = new com.google.android.gms.internal.zzob$zza;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ all -> 0x0070 }
        r2 = r2.elapsedRealtime();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r2 = r0.zzl(r2);	 Catch:{ all -> 0x0070 }
        r0 = 1;
        r3 = r5.zzUQ;	 Catch:{ all -> 0x0070 }
        if (r0 != r3) goto L_0x0039;
    L_0x001e:
        r0 = 6;
    L_0x001f:
        r0 = r2.zzac(r0);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzKo;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaO(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzUO;	 Catch:{ all -> 0x0070 }
        r2 = r2.zzJJ;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaP(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.zzjt();	 Catch:{ all -> 0x0070 }
        r5.zzUR = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
    L_0x0038:
        return;
    L_0x0039:
        r0 = r5.zzPF;	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x003c:
        r0 = r5.zzf(r6);	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0073;
    L_0x0042:
        r0 = new com.google.android.gms.internal.zzob$zza;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = r5.zzPF;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzac(r2);	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ all -> 0x0070 }
        r2 = r2.elapsedRealtime();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r0 = r0.zzl(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzKo;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaO(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzUO;	 Catch:{ all -> 0x0070 }
        r2 = r2.zzJJ;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaP(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.zzjt();	 Catch:{ all -> 0x0070 }
        r5.zzUR = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0038;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        throw r0;
    L_0x0073:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoa.zzk(long):void");
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
        synchronized (this.zzrN) {
            this.zzUQ = 2;
            this.zzPF = i;
            this.zzrN.notify();
        }
    }

    public void zzaN(String str) {
        synchronized (this.zzrN) {
            this.zzUQ = 1;
            this.zzrN.notify();
        }
    }

    public void zzab(int i) {
        zza(this.zzKo, 0);
    }

    public void zzcm() {
        if (this.zzUL != null && this.zzUL.zzjx() != null && this.zzUL.zzjw() != null) {
            zzoe zzjx = this.zzUL.zzjx();
            zzjx.zza(null);
            zzjx.zza((zzoc) this);
            zzdy com_google_android_gms_internal_zzdy = this.zzPo.zzSF.zzRd;
            zzjt zzjw = this.zzUL.zzjw();
            try {
                if (zzjw.isInitialized()) {
                    zzpx.zzXU.post(new 1(this, com_google_android_gms_internal_zzdy, zzjw));
                } else {
                    zzpx.zzXU.post(new 2(this, zzjw, com_google_android_gms_internal_zzdy, zzjx));
                }
            } catch (Throwable e) {
                zzpy.zzc("Fail to check if adapter is initialized.", e);
                zza(this.zzKo, 0);
            }
            zzk(zzv.zzcP().elapsedRealtime());
            zzjx.zza(null);
            zzjx.zza(null);
            if (this.zzUQ == 1) {
                this.zzUM.zzaN(this.zzKo);
            } else {
                this.zzUM.zza(this.zzKo, this.zzPF);
            }
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = this.zzUP - (zzv.zzcP().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.zzPF = 4;
            return false;
        }
        try {
            this.zzrN.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.zzPF = 5;
            return false;
        }
    }

    public zzob zzjq() {
        zzob com_google_android_gms_internal_zzob;
        synchronized (this.zzrN) {
            com_google_android_gms_internal_zzob = this.zzUR;
        }
        return com_google_android_gms_internal_zzob;
    }

    public zzji zzjr() {
        return this.zzUO;
    }

    public void zzjs() {
        zza(this.zzPo.zzSF.zzRd, this.zzUL.zzjw());
    }
}

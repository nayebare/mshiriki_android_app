package com.google.android.gms.internal;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.google.android.gms.internal.zzae.zza;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class zzap {
    private static final ConditionVariable zzpD;
    protected static volatile zzzf zzpE;
    private static volatile Random zzpG;
    private zzbc zzpC;
    protected Boolean zzpF;

    /* renamed from: com.google.android.gms.internal.zzap.1 */
    class C09801 implements Runnable {
        final /* synthetic */ zzap zzpH;

        C09801(zzap com_google_android_gms_internal_zzap) {
            this.zzpH = com_google_android_gms_internal_zzap;
        }

        public void run() {
            if (this.zzpH.zzpF == null) {
                synchronized (zzap.zzpD) {
                    if (this.zzpH.zzpF != null) {
                        return;
                    }
                    boolean booleanValue = ((Boolean) zzfx.zzDf.get()).booleanValue();
                    if (booleanValue) {
                        zzap.zzpE = new zzzf(this.zzpH.zzpC.getContext(), "ADSHIELD", null);
                    }
                    this.zzpH.zzpF = Boolean.valueOf(booleanValue);
                    zzap.zzpD.open();
                }
            }
        }
    }

    static {
        zzpD = new ConditionVariable();
        zzpE = null;
        zzpG = null;
    }

    public zzap(zzbc com_google_android_gms_internal_zzbc) {
        this.zzpC = com_google_android_gms_internal_zzbc;
        zza(com_google_android_gms_internal_zzbc.zzaJ());
    }

    private static Random zzU() {
        if (zzpG == null) {
            synchronized (zzap.class) {
                if (zzpG == null) {
                    zzpG = new Random();
                }
            }
        }
        return zzpG;
    }

    private void zza(Executor executor) {
        executor.execute(new C09801(this));
    }

    public int zzT() {
        try {
            return VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzU().nextInt();
        } catch (RuntimeException e) {
            return zzU().nextInt();
        }
    }

    public void zza(int i, int i2, long j) throws IOException {
        try {
            zzpD.block();
            if (this.zzpF.booleanValue() && zzpE != null && this.zzpC.zzaP()) {
                zza com_google_android_gms_internal_zzae_zza = new zza();
                com_google_android_gms_internal_zzae_zza.zzaR = this.zzpC.getContext().getPackageName();
                com_google_android_gms_internal_zzae_zza.zzaS = Long.valueOf(j);
                zzzf.zza zzm = zzpE.zzm(zzbut.zzf(com_google_android_gms_internal_zzae_zza));
                zzm.zzco(i2);
                zzm.zzcn(i);
                zzm.zze(this.zzpC.zzaN());
            }
        } catch (Exception e) {
        }
    }
}

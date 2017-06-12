package com.google.android.gms.internal;

import com.google.android.gms.internal.zzqi.zza;
import com.google.android.gms.internal.zzqi.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzmb
public class zzqj<T> implements zzqi<T> {
    protected int zzJh;
    protected final BlockingQueue<zza> zzYt;
    protected T zzYu;
    private final Object zzrN;

    public zzqj() {
        this.zzrN = new Object();
        this.zzJh = 0;
        this.zzYt = new LinkedBlockingQueue();
    }

    public int getStatus() {
        return this.zzJh;
    }

    public void reject() {
        synchronized (this.zzrN) {
            if (this.zzJh != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzJh = -1;
            for (zza com_google_android_gms_internal_zzqj_zza : this.zzYt) {
                com_google_android_gms_internal_zzqj_zza.zzYw.run();
            }
            this.zzYt.clear();
        }
    }

    public void zza(zzc<T> com_google_android_gms_internal_zzqi_zzc_T, zza com_google_android_gms_internal_zzqi_zza) {
        synchronized (this.zzrN) {
            if (this.zzJh == 1) {
                com_google_android_gms_internal_zzqi_zzc_T.zzd(this.zzYu);
            } else if (this.zzJh == -1) {
                com_google_android_gms_internal_zzqi_zza.run();
            } else if (this.zzJh == 0) {
                this.zzYt.add(new zza(this, com_google_android_gms_internal_zzqi_zzc_T, com_google_android_gms_internal_zzqi_zza));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzrN) {
            if (this.zzJh != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzYu = t;
            this.zzJh = 1;
            for (zza com_google_android_gms_internal_zzqj_zza : this.zzYt) {
                com_google_android_gms_internal_zzqj_zza.zzYv.zzd(t);
            }
            this.zzYt.clear();
        }
    }
}

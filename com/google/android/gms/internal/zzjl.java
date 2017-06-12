package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzju.zza;

@zzmb
public final class zzjl extends zza {
    private zzjn.zza zzKm;
    private zzjk zzKn;
    private final Object zzrN;

    public zzjl() {
        this.zzrN = new Object();
    }

    public void onAdClicked() {
        synchronized (this.zzrN) {
            if (this.zzKn != null) {
                this.zzKn.zzbP();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzrN) {
            if (this.zzKn != null) {
                this.zzKn.zzbQ();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.zzrN) {
            if (this.zzKm != null) {
                this.zzKm.zzD(i == 3 ? 1 : 2);
                this.zzKm = null;
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.zzrN) {
            if (this.zzKn != null) {
                this.zzKn.zzbU();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzrN) {
            if (this.zzKn != null) {
                this.zzKn.zzbR();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.zzrN) {
            if (this.zzKm != null) {
                this.zzKm.zzD(0);
                this.zzKm = null;
                return;
            }
            if (this.zzKn != null) {
                this.zzKn.zzbT();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.zzrN) {
            if (this.zzKn != null) {
                this.zzKn.zzbS();
            }
        }
    }

    public void zza(@Nullable zzjk com_google_android_gms_internal_zzjk) {
        synchronized (this.zzrN) {
            this.zzKn = com_google_android_gms_internal_zzjk;
        }
    }

    public void zza(zzjn.zza com_google_android_gms_internal_zzjn_zza) {
        synchronized (this.zzrN) {
            this.zzKm = com_google_android_gms_internal_zzjn_zza;
        }
    }

    public void zza(zzjv com_google_android_gms_internal_zzjv) {
        synchronized (this.zzrN) {
            if (this.zzKm != null) {
                this.zzKm.zza(0, com_google_android_gms_internal_zzjv);
                this.zzKm = null;
                return;
            }
            if (this.zzKn != null) {
                this.zzKn.zzbT();
            }
        }
    }
}

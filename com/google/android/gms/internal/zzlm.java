package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.zzln.zza;

@zzmb
public abstract class zzlm extends zzpd {
    protected final Context mContext;
    protected final zza zzPn;
    protected final zzov.zza zzPo;
    protected zzmk zzPp;
    protected final Object zzPr;
    protected final Object zzrN;

    protected zzlm(Context context, zzov.zza com_google_android_gms_internal_zzov_zza, zza com_google_android_gms_internal_zzln_zza) {
        super(true);
        this.zzrN = new Object();
        this.zzPr = new Object();
        this.mContext = context;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzPp = com_google_android_gms_internal_zzov_zza.zzVB;
        this.zzPn = com_google_android_gms_internal_zzln_zza;
    }

    public void onStop() {
    }

    protected abstract zzov zzP(int i);

    public void zzcm() {
        int errorCode;
        synchronized (this.zzrN) {
            zzpy.zzbc("AdRendererBackgroundTask started.");
            int i = this.zzPo.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzpy.zzbd(e.getMessage());
                } else {
                    zzpy.zzbe(e.getMessage());
                }
                if (this.zzPp == null) {
                    this.zzPp = new zzmk(errorCode);
                } else {
                    this.zzPp = new zzmk(errorCode, this.zzPp.zzKe);
                }
                zzpi.zzWR.post(new 1(this));
                i = errorCode;
            }
            zzpi.zzWR.post(new 2(this, zzP(i)));
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzn(zzov com_google_android_gms_internal_zzov) {
        this.zzPn.zzb(com_google_android_gms_internal_zzov);
    }
}

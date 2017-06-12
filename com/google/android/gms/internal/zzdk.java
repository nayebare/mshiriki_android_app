package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public class zzdk {
    @Nullable
    private Context mContext;
    private final Object zzrN;
    private final Runnable zzys;
    @Nullable
    private zzdn zzyt;
    @Nullable
    private zzdr zzyu;

    public zzdk() {
        this.zzys = new 1(this);
        this.zzrN = new Object();
    }

    private void connect() {
        synchronized (this.zzrN) {
            if (this.mContext == null || this.zzyt != null) {
                return;
            }
            this.zzyt = zza(new 3(this), new 4(this));
            this.zzyt.zzwT();
        }
    }

    private void disconnect() {
        synchronized (this.zzrN) {
            if (this.zzyt == null) {
                return;
            }
            if (this.zzyt.isConnected() || this.zzyt.isConnecting()) {
                this.zzyt.disconnect();
            }
            this.zzyt = null;
            this.zzyu = null;
            Binder.flushPendingCommands();
            zzv.zzcZ().zzkD();
        }
    }

    public void initialize(Context context) {
        if (context != null) {
            synchronized (this.zzrN) {
                if (this.mContext != null) {
                    return;
                }
                this.mContext = context.getApplicationContext();
                if (((Boolean) zzfx.zzEL.get()).booleanValue()) {
                    connect();
                } else if (((Boolean) zzfx.zzEK.get()).booleanValue()) {
                    zza(new 2(this));
                }
            }
        }
    }

    public zzdl zza(zzdo com_google_android_gms_internal_zzdo) {
        zzdl com_google_android_gms_internal_zzdl;
        synchronized (this.zzrN) {
            if (this.zzyu == null) {
                com_google_android_gms_internal_zzdl = new zzdl();
            } else {
                try {
                    com_google_android_gms_internal_zzdl = this.zzyu.zza(com_google_android_gms_internal_zzdo);
                } catch (Throwable e) {
                    zzpy.zzb("Unable to call into cache service.", e);
                    com_google_android_gms_internal_zzdl = new zzdl();
                }
            }
        }
        return com_google_android_gms_internal_zzdl;
    }

    protected zzdn zza(zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc) {
        return new zzdn(this.mContext, zzv.zzcZ().zzkC(), com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc);
    }

    protected void zza(zzda.zzb com_google_android_gms_internal_zzda_zzb) {
        zzv.zzcM().zza(com_google_android_gms_internal_zzda_zzb);
    }

    public void zzeq() {
        if (((Boolean) zzfx.zzEM.get()).booleanValue()) {
            synchronized (this.zzrN) {
                connect();
                zzv.zzcJ();
                zzpi.zzWR.removeCallbacks(this.zzys);
                zzv.zzcJ();
                zzpi.zzWR.postDelayed(this.zzys, ((Long) zzfx.zzEN.get()).longValue());
            }
        }
    }
}

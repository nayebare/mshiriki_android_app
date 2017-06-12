package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.zze;

@zzmb
public class zzfw {
    private final ConditionVariable zzAM;
    @Nullable
    private SharedPreferences zzAN;
    private final Object zzrN;
    private volatile boolean zztW;

    public zzfw() {
        this.zzrN = new Object();
        this.zzAM = new ConditionVariable();
        this.zztW = false;
        this.zzAN = null;
    }

    public void initialize(Context context) {
        if (!this.zztW) {
            synchronized (this.zzrN) {
                if (this.zztW) {
                    return;
                }
                try {
                    Context remoteContext = zze.getRemoteContext(context);
                    if (remoteContext == null) {
                        return;
                    }
                    this.zzAN = zzv.zzcT().zzm(remoteContext);
                    this.zztW = true;
                    this.zzAM.open();
                } finally {
                    this.zzAM.open();
                }
            }
        }
    }

    public <T> T zzd(zzft<T> com_google_android_gms_internal_zzft_T) {
        if (this.zzAM.block(5000)) {
            if (!this.zztW) {
                synchronized (this.zzrN) {
                    if (this.zztW) {
                    } else {
                        T zzfm = com_google_android_gms_internal_zzft_T.zzfm();
                        return zzfm;
                    }
                }
            }
            return zzpv.zzb(new 1(this, com_google_android_gms_internal_zzft_T));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}

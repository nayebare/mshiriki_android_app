package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;

@zzmb
public class zzda {
    private final Object zzxv;
    private zza zzxw;
    private boolean zzxx;

    public zzda() {
        this.zzxv = new Object();
        this.zzxw = null;
        this.zzxx = false;
    }

    @Nullable
    public Activity getActivity() {
        Activity activity = null;
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (this.zzxw != null) {
                activity = this.zzxw.getActivity();
            }
        }
        return activity;
    }

    @Nullable
    public Context getContext() {
        Context context = null;
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (this.zzxw != null) {
                context = this.zzxw.getContext();
            }
        }
        return context;
    }

    public void initialize(Context context) {
        synchronized (this.zzxv) {
            if (!this.zzxx) {
                if (!zzs.zzyA()) {
                    return;
                } else if (((Boolean) zzfx.zzCt.get()).booleanValue()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        zzpy.zzbe("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzxw == null) {
                        this.zzxw = new zza();
                    }
                    this.zzxw.zza(application, context);
                    this.zzxx = true;
                } else {
                    return;
                }
            }
        }
    }

    public void zza(zzb com_google_android_gms_internal_zzda_zzb) {
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (((Boolean) zzfx.zzCt.get()).booleanValue()) {
                if (this.zzxw == null) {
                    this.zzxw = new zza();
                }
                this.zzxw.zza(com_google_android_gms_internal_zzda_zzb);
            }
        }
    }
}

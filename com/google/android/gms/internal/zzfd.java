package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzeu.zza;

@zzmb
public class zzfd extends zzg<zzev> {
    public zzfd() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzy(iBinder);
    }

    public zzeu zzl(Context context) {
        try {
            return zza.zzu(((zzev) zzaT(context)).zza(zze.zzA(context), 10084000));
        } catch (Throwable e) {
            zzpy.zzc("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            zzpy.zzc("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected zzev zzy(IBinder iBinder) {
        return zzev.zza.zzv(iBinder);
    }
}

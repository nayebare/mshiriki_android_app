package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzns.zza;

@zzmb
public class zznv extends zzg<zzns> {
    public zznv() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    protected zzns zzak(IBinder iBinder) {
        return zza.zzai(iBinder);
    }

    public zznr zzb(Context context, zzjs com_google_android_gms_internal_zzjs) {
        Throwable e;
        try {
            return zznr.zza.zzah(((zzns) zzaT(context)).zza(zze.zzA(context), com_google_android_gms_internal_zzjs, 10084000));
        } catch (RemoteException e2) {
            e = e2;
            zzpy.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzpy.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzak(iBinder);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhc.zza;

@zzmb
public class zzhn extends zzg<zzhc> {
    public zzhn() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    protected zzhc zzL(IBinder iBinder) {
        return zza.zzD(iBinder);
    }

    public zzhb zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return zzhb.zza.zzC(((zzhc) zzaT(context)).zza(zze.zzA(context), zze.zzA(frameLayout), zze.zzA(frameLayout2), 10084000));
        } catch (RemoteException e2) {
            e = e2;
            zzpy.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzpy.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzL(iBinder);
    }
}

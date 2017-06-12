package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzbhy.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzbid extends zzg<zzbhy> {
    private static zzbid zzbQv;

    protected zzbid() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzbid zzSz() {
        if (zzbQv == null) {
            zzbQv = new zzbid();
        }
        return zzbQv;
    }

    public static zzbhv zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzbhw com_google_android_gms_internal_zzbhw) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzbhy) zzSz().zzaT(activity)).zza(zze.zzA(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzbhw);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzft(iBinder);
    }

    protected zzbhy zzft(IBinder iBinder) {
        return zza.zzfp(iBinder);
    }
}

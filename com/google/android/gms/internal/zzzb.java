package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzzd.zza;

public class zzzb extends zzl<zzzd> implements DeathRecipient {
    private static final zzyu zzamu;
    private CastDevice zzamc;
    private CastRemoteDisplaySessionCallbacks zzawh;
    private Bundle zzawi;

    static {
        zzamu = new zzyu("CastRemoteDisplayClientImpl");
    }

    public zzzb(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, CastDevice castDevice, Bundle bundle, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        zzamu.zzb("instance created", new Object[0]);
        this.zzawh = castRemoteDisplaySessionCallbacks;
        this.zzamc = castDevice;
        this.zzawi = bundle;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzamu.zzb("disconnect", new Object[0]);
        this.zzawh = null;
        this.zzamc = null;
        try {
            ((zzzd) zzwW()).disconnect();
            super.disconnect();
        } catch (RemoteException e) {
            super.disconnect();
        } catch (IllegalStateException e2) {
            super.disconnect();
        } catch (Throwable th) {
            super.disconnect();
        }
    }

    public void zza(zzzc com_google_android_gms_internal_zzzc) throws RemoteException {
        zzamu.zzb("stopRemoteDisplay", new Object[0]);
        ((zzzd) zzwW()).zza(com_google_android_gms_internal_zzzc);
    }

    public void zza(zzzc com_google_android_gms_internal_zzzc, int i) throws RemoteException {
        ((zzzd) zzwW()).zza(com_google_android_gms_internal_zzzc, i);
    }

    public void zza(zzzc com_google_android_gms_internal_zzzc, zzze com_google_android_gms_internal_zzze, String str) throws RemoteException {
        zzamu.zzb("startRemoteDisplay", new Object[0]);
        zzzc com_google_android_gms_internal_zzzc2 = com_google_android_gms_internal_zzzc;
        ((zzzd) zzwW()).zza(com_google_android_gms_internal_zzzc2, new 1(this, com_google_android_gms_internal_zzze), this.zzamc.getDeviceId(), str, this.zzawi);
    }

    public zzzd zzbi(IBinder iBinder) {
        return zza.zzbk(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    public /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbi(iBinder);
    }
}

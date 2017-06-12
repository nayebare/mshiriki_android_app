package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzaqm.zza;

public class zzaqq extends zzl<zzaqm> {
    public zzaqq(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 121, zzg.zzaA(context), connectionCallbacks, onConnectionFailedListener);
    }

    protected zzaqm zzdc(IBinder iBinder) {
        return zza.zzdb(iBinder);
    }

    @NonNull
    protected String zzeu() {
        return "com.google.android.gms.instantapps.START";
    }

    @NonNull
    protected String zzev() {
        return "com.google.android.gms.instantapps.internal.IInstantAppsService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzdc(iBinder);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzauq.zza;

public class zzaul extends zzl<zzauq> {
    public zzaul(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, 69, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzauq zzet(IBinder iBinder) {
        return zza.zzex(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
    }

    protected String zzev() {
        return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzet(iBinder);
    }
}

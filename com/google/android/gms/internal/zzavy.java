package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzavw.zza;

public class zzavy extends zzl<zzavw> {
    public zzavy(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public zzavw zzeL(IBinder iBinder) {
        return zza.zzeK(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzeL(iBinder);
    }
}

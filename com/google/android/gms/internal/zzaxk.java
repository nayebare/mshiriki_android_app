package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzaxj.zza;

public class zzaxk extends zzl<zzaxj> {
    public zzaxk(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg) {
        super(context, context.getMainLooper(), 73, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzaxj zzeW(IBinder iBinder) {
        return zza.zzeV(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzev() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzeW(iBinder);
    }
}

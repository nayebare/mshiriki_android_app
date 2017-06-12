package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public class zzanu extends zzano<zzaoj> {
    public static final Api<NoOptions> API;
    public static final zzf<zzanu> zzahc;

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzanu, NoOptions> {
        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzl(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzanu zzl(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzanu(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzahc = new zzf();
        API = new Api("Fitness.INTERNAL_API", new zza(), zzahc);
    }

    public zzanu(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
    }

    public zzaoj zzcl(IBinder iBinder) {
        return com.google.android.gms.internal.zzaoj.zza.zzcA(iBinder);
    }

    public String zzeu() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    public String zzev() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }

    public /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcl(iBinder);
    }
}

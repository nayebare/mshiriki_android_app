package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;

public class zzans extends zzano<zzaoh> {
    public static final Api<NoOptions> API;
    public static final zzf<zzans> zzahc;

    static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzans> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzans.API, googleApiClient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzans, NoOptions> {
        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzj(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzans zzj(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzans(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzahc = new zzf();
        API = new Api("Fitness.GOALS_API", new zzb(), zzahc);
    }

    public zzans(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 125, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
    }

    public zzaoh zzcj(IBinder iBinder) {
        return com.google.android.gms.internal.zzaoh.zza.zzcy(iBinder);
    }

    public String zzeu() {
        return "com.google.android.gms.fitness.GoalsApi";
    }

    public String zzev() {
        return "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi";
    }

    public /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcj(iBinder);
    }
}

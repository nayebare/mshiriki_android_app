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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;

public class zzanw extends zzano<zzaol> {
    public static final Api<NoOptions> API;
    public static final zzf<zzanw> zzahc;

    static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzanw> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzanw.API, googleApiClient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzanw, NoOptions> {
        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzn(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzanw zzn(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzanw(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            zzac.zzas(!status.isSuccess());
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static {
        zzahc = new zzf();
        API = new Api("Fitness.SENSORS_API", new zzb(), zzahc);
    }

    public zzanw(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 55, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
    }

    public zzaol zzcn(IBinder iBinder) {
        return com.google.android.gms.internal.zzaol.zza.zzcC(iBinder);
    }

    public String zzeu() {
        return "com.google.android.gms.fitness.SensorsApi";
    }

    public String zzev() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi";
    }

    public /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcn(iBinder);
    }
}

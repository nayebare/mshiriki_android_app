package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zzb;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.zzv;
import java.util.List;

public class zzaro implements GeofencingApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaro.1 */
    class C10121 extends zza {
        final /* synthetic */ PendingIntent zzaUp;
        final /* synthetic */ GeofencingRequest zzbke;

        C10121(zzaro com_google_android_gms_internal_zzaro, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
            this.zzbke = geofencingRequest;
            this.zzaUp = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbke, this.zzaUp, (zzb) this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaro.2 */
    class C10132 extends zza {
        final /* synthetic */ zzv zzbkf;

        C10132(zzaro com_google_android_gms_internal_zzaro, GoogleApiClient googleApiClient, zzv com_google_android_gms_location_zzv) {
            this.zzbkf = com_google_android_gms_location_zzv;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbkf, (zzb) this);
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C10121(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, zzv.zzb(pendingIntent));
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return zza(googleApiClient, zzv.zzC(list));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, zzv com_google_android_gms_location_zzv) {
        return googleApiClient.zzb(new C10132(this, googleApiClient, com_google_android_gms_location_zzv));
    }
}

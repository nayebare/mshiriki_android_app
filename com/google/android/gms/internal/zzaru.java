package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zzv;

public class zzaru extends zzari {
    private final zzart zzbkm;

    private static final class zza extends com.google.android.gms.internal.zzarq.zza {
        private com.google.android.gms.internal.zzzv.zzb<Status> zzbkn;

        public zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzbkn = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        public void zza(int i, String[] strArr) {
            if (this.zzbkn == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.zzbkn.setResult(LocationStatusCodes.zzkl(LocationStatusCodes.zzkk(i)));
            this.zzbkn = null;
        }

        public void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzarq.zza {
        private com.google.android.gms.internal.zzzv.zzb<Status> zzbkn;

        public zzb(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzbkn = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        private void zzkp(int i) {
            if (this.zzbkn == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.zzbkn.setResult(LocationStatusCodes.zzkl(LocationStatusCodes.zzkk(i)));
            this.zzbkn = null;
        }

        public void zza(int i, PendingIntent pendingIntent) {
            zzkp(i);
        }

        public void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        public void zzb(int i, String[] strArr) {
            zzkp(i);
        }
    }

    private static final class zzc extends com.google.android.gms.internal.zzars.zza {
        private com.google.android.gms.internal.zzzv.zzb<LocationSettingsResult> zzbkn;

        public zzc(com.google.android.gms.internal.zzzv.zzb<LocationSettingsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult) {
            zzac.zzb(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult != null, (Object) "listener can't be null.");
            this.zzbkn = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult;
        }

        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzbkn.setResult(locationSettingsResult);
            this.zzbkn = null;
        }
    }

    public zzaru(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzg.zzaA(context));
    }

    public zzaru(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzg);
        this.zzbkm = new zzart(context, this.zzbjV);
    }

    public void disconnect() {
        synchronized (this.zzbkm) {
            if (isConnected()) {
                try {
                    this.zzbkm.removeAllListeners();
                    this.zzbkm.zzHC();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.zzbkm.getLastLocation();
    }

    public LocationAvailability zzHB() {
        return this.zzbkm.zzHB();
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzwV();
        zzac.zzw(pendingIntent);
        zzac.zzb(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((zzarr) zzwW()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        this.zzbkm.zza(pendingIntent, com_google_android_gms_internal_zzarp);
    }

    public void zza(com.google.android.gms.internal.zzaaz.zzb<LocationListener> com_google_android_gms_internal_zzaaz_zzb_com_google_android_gms_location_LocationListener, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        this.zzbkm.zza((com.google.android.gms.internal.zzaaz.zzb) com_google_android_gms_internal_zzaaz_zzb_com_google_android_gms_location_LocationListener, com_google_android_gms_internal_zzarp);
    }

    public void zza(zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        this.zzbkm.zza(com_google_android_gms_internal_zzarp);
    }

    public void zza(zzarv com_google_android_gms_internal_zzarv, zzaaz<LocationCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_location_LocationCallback, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        synchronized (this.zzbkm) {
            this.zzbkm.zza(com_google_android_gms_internal_zzarv, (zzaaz) com_google_android_gms_internal_zzaaz_com_google_android_gms_location_LocationCallback, com_google_android_gms_internal_zzarp);
        }
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzwV();
        zzac.zzb((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        zzac.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzarr) zzwW()).zza(geofencingRequest, pendingIntent, new zza(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status));
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        this.zzbkm.zza(locationRequest, pendingIntent, com_google_android_gms_internal_zzarp);
    }

    public void zza(LocationRequest locationRequest, zzaaz<LocationListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_location_LocationListener, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        synchronized (this.zzbkm) {
            this.zzbkm.zza(locationRequest, (zzaaz) com_google_android_gms_internal_zzaaz_com_google_android_gms_location_LocationListener, com_google_android_gms_internal_zzarp);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.internal.zzzv.zzb<LocationSettingsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult, String str) throws RemoteException {
        boolean z = true;
        zzwV();
        zzac.zzb(locationSettingsRequest != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult == null) {
            z = false;
        }
        zzac.zzb(z, (Object) "listener can't be null.");
        ((zzarr) zzwW()).zza(locationSettingsRequest, new zzc(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public void zza(zzv com_google_android_gms_location_zzv, com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzwV();
        zzac.zzb((Object) com_google_android_gms_location_zzv, (Object) "removeGeofencingRequest can't be null.");
        zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzarr) zzwW()).zza(com_google_android_gms_location_zzv, new zzb(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzaC(boolean z) throws RemoteException {
        this.zzbkm.zzaC(z);
    }

    public void zzb(com.google.android.gms.internal.zzaaz.zzb<LocationCallback> com_google_android_gms_internal_zzaaz_zzb_com_google_android_gms_location_LocationCallback, zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
        this.zzbkm.zzb(com_google_android_gms_internal_zzaaz_zzb_com_google_android_gms_location_LocationCallback, com_google_android_gms_internal_zzarp);
    }

    public void zzc(PendingIntent pendingIntent) throws RemoteException {
        zzwV();
        zzac.zzw(pendingIntent);
        ((zzarr) zzwW()).zzc(pendingIntent);
    }

    public void zzd(Location location) throws RemoteException {
        this.zzbkm.zzd(location);
    }
}

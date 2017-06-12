package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzarl implements FusedLocationProviderApi {

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

    /* renamed from: com.google.android.gms.internal.zzarl.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ PendingIntent zzbjT;

        AnonymousClass10(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjT, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.1 */
    class C10031 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationListener zzbjY;

        C10031(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.zzbjX = locationRequest;
            this.zzbjY = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, zzaba.zzb(this.zzbjY, zzasn.zzIx(), LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.2 */
    class C10042 extends zza {
        final /* synthetic */ LocationCallback zzbjZ;

        C10042(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
            this.zzbjZ = locationCallback;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzb(zzaba.zza(this.zzbjZ, LocationCallback.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.3 */
    class C10053 extends zza {
        final /* synthetic */ boolean zzbka;

        C10053(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbka = z;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzaC(this.zzbka);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.4 */
    class C10064 extends zza {
        final /* synthetic */ Location zzbkb;

        C10064(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, Location location) {
            this.zzbkb = location;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzd(this.zzbkb);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.5 */
    class C10075 extends zza {
        C10075(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.6 */
    class C10086 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationListener zzbjY;
        final /* synthetic */ Looper zzbkc;

        C10086(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.zzbjX = locationRequest;
            this.zzbjY = locationListener;
            this.zzbkc = looper;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, zzaba.zzb(this.zzbjY, zzasn.zzb(this.zzbkc), LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.7 */
    class C10097 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationCallback zzbjZ;
        final /* synthetic */ Looper zzbkc;

        C10097(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
            this.zzbjX = locationRequest;
            this.zzbjZ = locationCallback;
            this.zzbkc = looper;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(zzarv.zzb(this.zzbjX), zzaba.zzb(this.zzbjZ, zzasn.zzb(this.zzbkc), LocationCallback.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.8 */
    class C10108 extends zza {
        final /* synthetic */ PendingIntent zzbjT;
        final /* synthetic */ LocationRequest zzbjX;

        C10108(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.zzbjX = locationRequest;
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, this.zzbjT, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.9 */
    class C10119 extends zza {
        final /* synthetic */ LocationListener zzbjY;

        C10119(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.zzbjY = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(zzaba.zza(this.zzbjY, LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzarp.zza {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zza(zzarm com_google_android_gms_internal_zzarm) {
            this.zzaFq.setResult(com_google_android_gms_internal_zzarm.getStatus());
        }
    }

    public PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C10075(this, googleApiClient));
    }

    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzj(googleApiClient).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzj(googleApiClient).zzHB();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AnonymousClass10(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.zzb(new C10042(this, googleApiClient, locationCallback));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.zzb(new C10119(this, googleApiClient, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C10108(this, googleApiClient, locationRequest, pendingIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.zzb(new C10097(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        zzac.zzb(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return googleApiClient.zzb(new C10031(this, googleApiClient, locationRequest, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.zzb(new C10086(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.zzb(new C10064(this, googleApiClient, location));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zzb(new C10053(this, googleApiClient, z));
    }
}

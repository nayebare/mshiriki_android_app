package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zzb;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzasc implements SettingsApi {

    /* renamed from: com.google.android.gms.internal.zzasc.1 */
    class C10171 extends zza<LocationSettingsResult> {
        final /* synthetic */ LocationSettingsRequest zzbkx;
        final /* synthetic */ String zzbky;

        C10171(zzasc com_google_android_gms_internal_zzasc, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
            this.zzbkx = locationSettingsRequest;
            this.zzbky = str;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbkx, (zzb) this, this.zzbky);
        }

        public LocationSettingsResult zzbo(Status status) {
            return new LocationSettingsResult(status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbo(status);
        }
    }

    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        return zza(googleApiClient, locationSettingsRequest, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        return googleApiClient.zza(new C10171(this, googleApiClient, locationSettingsRequest, str));
    }
}

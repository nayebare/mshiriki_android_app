package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzaxl implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzaxi.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbG(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends com.google.android.gms.internal.zzzv.zza<Status, zzaxk> {
        private final String zzbBR;
        private final String zzbBU;
        private final boolean zzbBV;

        /* renamed from: com.google.android.gms.internal.zzaxl.zzb.1 */
        class C11071 extends zza {
            final /* synthetic */ zzb zzbBW;

            C11071(zzb com_google_android_gms_internal_zzaxl_zzb) {
                this.zzbBW = com_google_android_gms_internal_zzaxl_zzb;
            }

            public void zzbG(Status status) {
                if (this.zzbBW.zzbBV) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.zzbBW.zzb(status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.API, googleApiClient);
            this.zzbBV = Log.isLoggable("SearchAuth", 3);
            this.zzbBR = str;
            this.zzbBU = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzaxk com_google_android_gms_internal_zzaxk) throws RemoteException {
            if (this.zzbBV) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            ((zzaxj) com_google_android_gms_internal_zzaxk.zzwW()).zzb(new C11071(this), this.zzbBU, this.zzbBR);
        }

        protected Status zzb(Status status) {
            if (this.zzbBV) {
                String str = "SearchAuth";
                String str2 = "ClearTokenImpl received failure: ";
                String valueOf = String.valueOf(status.getStatusMessage());
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class zzc extends com.google.android.gms.internal.zzzv.zza<GoogleNowAuthResult, zzaxk> {
        private final String zzbBU;
        private final boolean zzbBV;
        private final String zzbBX;

        /* renamed from: com.google.android.gms.internal.zzaxl.zzc.1 */
        class C11081 extends zza {
            final /* synthetic */ zzc zzbBY;

            C11081(zzc com_google_android_gms_internal_zzaxl_zzc) {
                this.zzbBY = com_google_android_gms_internal_zzaxl_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzbBY.zzbBV) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzbBY.zzb(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.API, googleApiClient);
            this.zzbBV = Log.isLoggable("SearchAuth", 3);
            this.zzbBX = str;
            this.zzbBU = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzaxk com_google_android_gms_internal_zzaxk) throws RemoteException {
            if (this.zzbBV) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            ((zzaxj) com_google_android_gms_internal_zzaxk.zzwW()).zza(new C11081(this), this.zzbBU, this.zzbBX);
        }

        protected GoogleNowAuthResult zzbH(Status status) {
            if (this.zzbBV) {
                String str = "SearchAuth";
                String str2 = "GetGoogleNowAuthImpl received failure: ";
                String valueOf = String.valueOf(status.getStatusMessage());
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbH(status);
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzahq;
        private final GoogleNowAuthState zzbBZ;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzahq = status;
            this.zzbBZ = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzbBZ;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzb(googleApiClient, str));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzc(googleApiClient, str));
    }
}

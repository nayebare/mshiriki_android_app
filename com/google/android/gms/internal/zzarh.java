package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zzarh implements ActivityRecognitionApi {

    private static abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza<Status> {
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

    /* renamed from: com.google.android.gms.internal.zzarh.1 */
    class C10001 extends zza {
        final /* synthetic */ long zzbjS;
        final /* synthetic */ PendingIntent zzbjT;

        C10001(zzarh com_google_android_gms_internal_zzarh, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
            this.zzbjS = j;
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjS, this.zzbjT);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarh.2 */
    class C10012 extends zza {
        final /* synthetic */ PendingIntent zzbjT;

        C10012(zzarh com_google_android_gms_internal_zzarh, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzc(this.zzbjT);
            zzb(Status.zzayh);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C10012(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C10001(this, googleApiClient, j, pendingIntent));
    }
}

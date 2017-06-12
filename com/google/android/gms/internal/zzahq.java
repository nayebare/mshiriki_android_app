package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzahq implements DrivePreferencesApi {

    private abstract class zzc extends zzahj<FileUploadPreferencesResult> {
        final /* synthetic */ zzahq zzaMa;

        public zzc(zzahq com_google_android_gms_internal_zzahq, GoogleApiClient googleApiClient) {
            this.zzaMa = com_google_android_gms_internal_zzahq;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzR(Status status) {
            return new zzb(status, null, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzR(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahq.1 */
    class C09441 extends zzc {
        final /* synthetic */ zzahq zzaMa;

        C09441(zzahq com_google_android_gms_internal_zzahq, GoogleApiClient googleApiClient) {
            this.zzaMa = com_google_android_gms_internal_zzahq;
            super(com_google_android_gms_internal_zzahq, googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zzd(new zza(this, null));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahq.2 */
    class C09452 extends com.google.android.gms.internal.zzahj.zza {
        final /* synthetic */ zzahy zzaMb;

        C09452(zzahq com_google_android_gms_internal_zzahq, GoogleApiClient googleApiClient, zzahy com_google_android_gms_internal_zzahy) {
            this.zzaMb = com_google_android_gms_internal_zzahy;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzakj(this.zzaMb), new zzakp(this));
        }
    }

    private class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<FileUploadPreferencesResult> zzaFq;
        final /* synthetic */ zzahq zzaMa;

        private zza(zzahq com_google_android_gms_internal_zzahq, com.google.android.gms.internal.zzzv.zzb<FileUploadPreferencesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzaMa = com_google_android_gms_internal_zzahq;
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzb(status, null, null));
        }

        public void zza(zzaiw com_google_android_gms_internal_zzaiw) throws RemoteException {
            this.zzaFq.setResult(new zzb(Status.zzayh, com_google_android_gms_internal_zzaiw.zzAq(), null));
        }
    }

    private class zzb implements FileUploadPreferencesResult {
        private final FileUploadPreferences zzaMc;
        private final Status zzahq;

        private zzb(zzahq com_google_android_gms_internal_zzahq, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzahq = status;
            this.zzaMc = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaMc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C09441(this, googleApiClient));
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof zzahy) {
            return googleApiClient.zzb(new C09452(this, googleApiClient, (zzahy) fileUploadPreferences));
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}

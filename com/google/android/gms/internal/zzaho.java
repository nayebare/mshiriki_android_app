package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.zzk;

public class zzaho extends zzahr implements DriveFolder {

    static abstract class zzd extends zzahj<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFileResult zzP(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzP(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaho.1 */
    class C09421 extends zzd {
        final /* synthetic */ MetadataChangeSet zzaLS;
        final /* synthetic */ int zzaLT;
        final /* synthetic */ int zzaLU;
        final /* synthetic */ zzk zzaLV;
        final /* synthetic */ zzaho zzaLW;

        C09421(zzaho com_google_android_gms_internal_zzaho, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, zzk com_google_android_gms_drive_zzk) {
            this.zzaLW = com_google_android_gms_internal_zzaho;
            this.zzaLS = metadataChangeSet;
            this.zzaLT = i;
            this.zzaLU = i2;
            this.zzaLV = com_google_android_gms_drive_zzk;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            this.zzaLS.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzagz(this.zzaLW.getDriveId(), this.zzaLS.zzzP(), this.zzaLT, this.zzaLU, this.zzaLV), new zza(this));
        }
    }

    static abstract class zzf extends zzahj<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFolderResult zzQ(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzQ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaho.2 */
    class C09432 extends zzf {
        final /* synthetic */ MetadataChangeSet zzaLS;
        final /* synthetic */ zzaho zzaLW;

        C09432(zzaho com_google_android_gms_internal_zzaho, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.zzaLW = com_google_android_gms_internal_zzaho;
            this.zzaLS = metadataChangeSet;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            this.zzaLS.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzahb(this.zzaLW.getDriveId(), this.zzaLS.zzzP()), new zzb(this));
        }
    }

    private static class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<DriveFileResult> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<DriveFileResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzc(status, null));
        }

        public void zza(zzaja com_google_android_gms_internal_zzaja) throws RemoteException {
            this.zzaFq.setResult(new zzc(Status.zzayh, new zzahm(com_google_android_gms_internal_zzaja.getDriveId())));
        }
    }

    private static class zzb extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<DriveFolderResult> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<DriveFolderResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zze(status, null));
        }

        public void zza(zzaja com_google_android_gms_internal_zzaja) throws RemoteException {
            this.zzaFq.setResult(new zze(Status.zzayh, new zzaho(com_google_android_gms_internal_zzaja.getDriveId())));
        }
    }

    private static class zzc implements DriveFileResult {
        private final DriveFile zzaLX;
        private final Status zzahq;

        public zzc(Status status, DriveFile driveFile) {
            this.zzahq = status;
            this.zzaLX = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzaLX;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static class zze implements DriveFolderResult {
        private final DriveFolder zzaLY;
        private final Status zzahq;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzahq = status;
            this.zzaLY = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzaLY;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public zzaho(DriveId driveId) {
        super(driveId);
    }

    private int zza(DriveContents driveContents, zzj com_google_android_gms_drive_metadata_internal_zzj) {
        if (driveContents == null) {
            return (com_google_android_gms_drive_metadata_internal_zzj == null || !com_google_android_gms_drive_metadata_internal_zzj.zzAM()) ? 1 : 0;
        } else {
            int requestId = driveContents.zzzB().getRequestId();
            driveContents.zzzC();
            return requestId;
        }
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, zzk com_google_android_gms_drive_zzk) {
        zzj zzdO = zzj.zzdO(metadataChangeSet.getMimeType());
        int i2 = (zzdO == null || !zzdO.zzAM()) ? 0 : 1;
        return googleApiClient.zzb(new C09421(this, googleApiClient, metadataChangeSet, i, i2, com_google_android_gms_drive_zzk));
    }

    private MetadataChangeSet zza(MetadataChangeSet metadataChangeSet, String str) {
        return metadataChangeSet.zza(zzalh.zzaOk, str);
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    private void zzb(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzk com_google_android_gms_drive_zzk) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzj zzdO = zzj.zzdO(metadataChangeSet.getMimeType());
        if (zzdO == null || !zzdO.isFolder()) {
            com_google_android_gms_drive_zzk.zzh(googleApiClient);
            if (driveContents != null) {
                if (!(driveContents instanceof zzahl)) {
                    throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
                } else if (driveContents.getDriveId() != null) {
                    throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
                } else if (driveContents.zzzD()) {
                    throw new IllegalArgumentException("DriveContents are already closed.");
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
    }

    private void zzb(MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzj zzdO = zzj.zzdO(metadataChangeSet.getMimeType());
        if (zzdO != null && !zzdO.zzAL()) {
            throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, zzk.zza(executionOptions));
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.zzb(new C09432(this, googleApiClient, metadataChangeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzahi().query(googleApiClient, zza(query));
    }

    public PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzk com_google_android_gms_drive_zzk) {
        zzk com_google_android_gms_drive_zzk2 = com_google_android_gms_drive_zzk == null ? (zzk) new com.google.android.gms.drive.zzk.zza().build() : com_google_android_gms_drive_zzk;
        zzb(googleApiClient, metadataChangeSet, driveContents, com_google_android_gms_drive_zzk2);
        int zza = zza(driveContents, zzj.zzdO(metadataChangeSet.getMimeType()));
        String zzzK = com_google_android_gms_drive_zzk2.zzzK();
        if (zzzK != null) {
            metadataChangeSet = zza(metadataChangeSet, zzzK);
        }
        return zza(googleApiClient, metadataChangeSet, zza, com_google_android_gms_drive_zzk2);
    }
}

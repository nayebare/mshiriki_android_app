package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzaaz.zzc;

public class zzahm extends zzahr implements DriveFile {

    /* renamed from: com.google.android.gms.internal.zzahm.1 */
    class C09401 extends zzc {
        final /* synthetic */ DownloadProgressListener zzaLN;
        final /* synthetic */ zzahm zzaLO;
        final /* synthetic */ int zzaLm;

        C09401(zzahm com_google_android_gms_internal_zzahm, GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
            this.zzaLO = com_google_android_gms_internal_zzahm;
            this.zzaLm = i;
            this.zzaLN = downloadProgressListener;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            zza(com_google_android_gms_internal_zzahk.zzAi().zza(new zzajw(this.zzaLO.getDriveId(), this.zzaLm, 0), new zzajy(this, this.zzaLN)).zzAn());
        }
    }

    private static class zza implements DownloadProgressListener {
        private final zzaaz<DownloadProgressListener> zzaLP;

        /* renamed from: com.google.android.gms.internal.zzahm.zza.1 */
        class C09411 implements zzc<DownloadProgressListener> {
            final /* synthetic */ long zzaLQ;
            final /* synthetic */ long zzaLR;

            C09411(zza com_google_android_gms_internal_zzahm_zza, long j, long j2) {
                this.zzaLQ = j;
                this.zzaLR = j2;
            }

            public void zza(DownloadProgressListener downloadProgressListener) {
                downloadProgressListener.onProgress(this.zzaLQ, this.zzaLR);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((DownloadProgressListener) obj);
            }

            public void zzvy() {
            }
        }

        public zza(zzaaz<DownloadProgressListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long j, long j2) {
            this.zzaLP.zza(new C09411(this, j, j2));
        }
    }

    public zzahm(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzr(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
        if (i == DriveFile.MODE_READ_ONLY || i == DriveFile.MODE_WRITE_ONLY || i == DriveFile.MODE_READ_WRITE) {
            return googleApiClient.zza(new C09401(this, googleApiClient, i, zza(googleApiClient, downloadProgressListener)));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.internal.zzzv.zzb;

class zzajy extends zzagh {
    private final zzb<DriveContentsResult> zzaFq;
    private final DownloadProgressListener zzaMY;

    zzajy(zzb<DriveContentsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzaMY = downloadProgressListener;
    }

    public void onError(Status status) throws RemoteException {
        this.zzaFq.setResult(new zzb(status, null));
    }

    public void zza(zzaiu com_google_android_gms_internal_zzaiu) throws RemoteException {
        this.zzaFq.setResult(new zzb(com_google_android_gms_internal_zzaiu.zzAp() ? new Status(-1) : Status.zzayh, new zzahl(com_google_android_gms_internal_zzaiu.zzAo())));
    }

    public void zza(zzaiy com_google_android_gms_internal_zzaiy) throws RemoteException {
        if (this.zzaMY != null) {
            this.zzaMY.onProgress(com_google_android_gms_internal_zzaiy.zzAr(), com_google_android_gms_internal_zzaiy.zzAs());
        }
    }
}

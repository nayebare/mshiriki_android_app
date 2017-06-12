package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zzb;

public class zzakp extends zzagh {
    private final zzb<Status> zzaFq;

    public zzakp(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
        this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
    }

    public void onError(Status status) throws RemoteException {
        this.zzaFq.setResult(status);
    }

    public void onSuccess() throws RemoteException {
        this.zzaFq.setResult(Status.zzayh);
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

@Deprecated
final class zzuf$zza implements ActionResult {
    private zzuf zzagX;
    private PendingResult<Status> zzagY;
    private Action zzagZ;

    zzuf$zza(zzuf com_google_android_gms_internal_zzuf, PendingResult<Status> pendingResult, Action action) {
        this.zzagX = com_google_android_gms_internal_zzuf;
        this.zzagY = pendingResult;
        this.zzagZ = action;
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient) {
        String packageName = googleApiClient.getContext().getPackageName();
        zztx zza = zzue.zza(this.zzagZ, System.currentTimeMillis(), packageName, 2);
        return this.zzagX.zza(googleApiClient, new zztx[]{zza});
    }

    public PendingResult<Status> getPendingResult() {
        return this.zzagY;
    }
}

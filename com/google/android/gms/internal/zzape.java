package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaos.zza;
import com.google.android.gms.internal.zzzv.zzb;

public class zzape extends zza {
    private final zzb<Status> zzaFq;

    public zzape(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
        this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
    }

    public void zzp(Status status) {
        this.zzaFq.setResult(status);
    }
}

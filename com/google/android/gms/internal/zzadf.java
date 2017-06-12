package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zzacz.zza;
import com.google.android.gms.internal.zzacz.zzb;

public class zzadf extends zzc<NoOptions> {
    public zzadf(Context context) {
        super(context, zzacy.API, null, new zzzr());
    }

    public PendingResult<zzb> zza(zza com_google_android_gms_internal_zzacz_zza) {
        return zzacy.zzaHm.zza(asGoogleApiClient(), com_google_android_gms_internal_zzacz_zza);
    }
}

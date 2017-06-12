package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzzv.zza;
import com.google.android.gms.safetynet.SafetyNet;

abstract class zzawx<R extends Result> extends zza<R, zzaxb> {
    public zzawx(GoogleApiClient googleApiClient) {
        super(SafetyNet.API, googleApiClient);
    }
}

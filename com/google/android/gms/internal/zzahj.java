package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

public abstract class zzahj<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzahk> {

    public static abstract class zza extends zzahj<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzahj(GoogleApiClient googleApiClient) {
        super(Drive.zzahc, googleApiClient);
    }
}

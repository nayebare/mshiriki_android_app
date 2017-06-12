package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.awareness.FenceApi;
import com.google.android.gms.awareness.fence.FenceQueryRequest;
import com.google.android.gms.awareness.fence.FenceQueryResult;
import com.google.android.gms.awareness.fence.FenceUpdateRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaez.zza;
import com.google.android.gms.internal.zzaez.zzc;
import com.google.android.gms.internal.zzzv.zzb;

public class zzadz implements FenceApi {

    /* renamed from: com.google.android.gms.internal.zzadz.1 */
    class C09141 extends zzc {
        final /* synthetic */ FenceUpdateRequest zzaHL;

        C09141(zzadz com_google_android_gms_internal_zzadz, GoogleApiClient googleApiClient, FenceUpdateRequest fenceUpdateRequest) {
            this.zzaHL = fenceUpdateRequest;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzb) this, (zzaeo) this.zzaHL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzadz.2 */
    class C09152 extends zza {
        final /* synthetic */ FenceQueryRequest zzaHM;

        C09152(zzadz com_google_android_gms_internal_zzadz, GoogleApiClient googleApiClient, FenceQueryRequest fenceQueryRequest) {
            this.zzaHM = fenceQueryRequest;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzb) this, (zzaeg) this.zzaHM);
        }
    }

    public PendingResult<FenceQueryResult> queryFences(GoogleApiClient googleApiClient, FenceQueryRequest fenceQueryRequest) {
        return googleApiClient.zza(new C09152(this, googleApiClient, fenceQueryRequest));
    }

    public PendingResult<Status> updateFences(GoogleApiClient googleApiClient, FenceUpdateRequest fenceUpdateRequest) {
        return googleApiClient.zza(new C09141(this, googleApiClient, fenceUpdateRequest));
    }
}

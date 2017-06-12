package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.GoalsApi;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;
import com.google.android.gms.internal.zzaoe.zza;

public class zzaoy implements GoalsApi {

    /* renamed from: com.google.android.gms.internal.zzaoy.1 */
    class C09711 extends zza<GoalsResult> {
        final /* synthetic */ GoalsReadRequest zzaUi;

        /* renamed from: com.google.android.gms.internal.zzaoy.1.1 */
        class C09701 extends zza {
            final /* synthetic */ C09711 zzaUj;

            C09701(C09711 c09711) {
                this.zzaUj = c09711;
            }

            public void zza(GoalsResult goalsResult) throws RemoteException {
                this.zzaUj.zzb(goalsResult);
            }
        }

        C09711(zzaoy com_google_android_gms_internal_zzaoy, GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
            this.zzaUi = goalsReadRequest;
            super(googleApiClient);
        }

        protected GoalsResult zzV(Status status) {
            return GoalsResult.zzaf(status);
        }

        protected void zza(zzans com_google_android_gms_internal_zzans) throws RemoteException {
            ((zzaoh) com_google_android_gms_internal_zzans.zzwW()).zza(new GoalsReadRequest(this.zzaUi, new C09701(this)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzV(status);
        }
    }

    public PendingResult<GoalsResult> readCurrentGoals(GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
        return googleApiClient.zza(new C09711(this, googleApiClient, goalsReadRequest));
    }
}

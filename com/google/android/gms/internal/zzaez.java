package com.google.android.gms.internal;

import com.google.android.gms.awareness.fence.FenceQueryResult;
import com.google.android.gms.awareness.fence.FenceStateMap;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzaez {

    public static abstract class zzc extends com.google.android.gms.internal.zzzv.zza<Status, zzafa> {
        public zzc(GoogleApiClient googleApiClient) {
            super(zzadu.API, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static abstract class zza extends com.google.android.gms.internal.zzzv.zza<FenceQueryResult, zzafa> {

        /* renamed from: com.google.android.gms.internal.zzaez.zza.1 */
        class C09171 implements FenceQueryResult {
            final /* synthetic */ Status zzamf;

            C09171(zza com_google_android_gms_internal_zzaez_zza, Status status) {
                this.zzamf = status;
            }

            public FenceStateMap getFenceStateMap() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public zza(GoogleApiClient googleApiClient) {
            super(zzadu.API, googleApiClient);
        }

        public FenceQueryResult zzJ(Status status) {
            return new C09171(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzJ(status);
        }
    }

    public static abstract class zzb extends com.google.android.gms.internal.zzzv.zza<zzwl, zzafa> {

        /* renamed from: com.google.android.gms.internal.zzaez.zzb.1 */
        class C09181 implements zzwl {
            final /* synthetic */ Status zzamf;

            C09181(zzb com_google_android_gms_internal_zzaez_zzb, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public zzwg zzrD() {
                return null;
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzadu.API, googleApiClient);
        }

        public zzwl zzK(Status status) {
            return new C09181(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzK(status);
        }
    }
}

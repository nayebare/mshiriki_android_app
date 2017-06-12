package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzapc implements SensorsApi {

    /* renamed from: com.google.android.gms.internal.zzapc.1 */
    class C09861 extends zza<DataSourcesResult> {
        final /* synthetic */ DataSourcesRequest zzaUy;

        C09861(zzapc com_google_android_gms_internal_zzapc, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
            this.zzaUy = dataSourcesRequest;
            super(googleApiClient);
        }

        protected DataSourcesResult zzZ(Status status) {
            return DataSourcesResult.zzad(status);
        }

        protected void zza(zzanw com_google_android_gms_internal_zzanw) throws RemoteException {
            ((zzaol) com_google_android_gms_internal_zzanw.zzwW()).zza(new DataSourcesRequest(this.zzaUy, new zzanp(this)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzZ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapc.2 */
    class C09872 extends zzc {
        final /* synthetic */ zzu zzaUA;
        final /* synthetic */ PendingIntent zzaUB;
        final /* synthetic */ SensorRequest zzaUz;

        C09872(zzapc com_google_android_gms_internal_zzapc, GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent) {
            this.zzaUz = sensorRequest;
            this.zzaUA = com_google_android_gms_fitness_data_zzu;
            this.zzaUB = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzanw com_google_android_gms_internal_zzanw) throws RemoteException {
            ((zzaol) com_google_android_gms_internal_zzanw.zzwW()).zza(new zzav(this.zzaUz, this.zzaUA, this.zzaUB, new zzape(this)));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private interface zza {
        void zzBU();
    }

    /* renamed from: com.google.android.gms.internal.zzapc.3 */
    class C09883 implements zza {
        final /* synthetic */ OnDataPointListener zzaUC;

        C09883(zzapc com_google_android_gms_internal_zzapc, OnDataPointListener onDataPointListener) {
            this.zzaUC = onDataPointListener;
        }

        public void zzBU() {
            com.google.android.gms.fitness.request.zzao.zza.zzCm().zzc(this.zzaUC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapc.4 */
    class C09894 extends zzc {
        final /* synthetic */ zza zzaUD;
        final /* synthetic */ zzu zzaUE;
        final /* synthetic */ PendingIntent zzaUp;

        C09894(zzapc com_google_android_gms_internal_zzapc, GoogleApiClient googleApiClient, zza com_google_android_gms_internal_zzapc_zza, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent) {
            this.zzaUD = com_google_android_gms_internal_zzapc_zza;
            this.zzaUE = com_google_android_gms_fitness_data_zzu;
            this.zzaUp = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzanw com_google_android_gms_internal_zzanw) throws RemoteException {
            ((zzaol) com_google_android_gms_internal_zzanw.zzwW()).zza(new zzax(this.zzaUE, this.zzaUp, new zzb(this.zzaUD, null)));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzaos.zza {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;
        private final zza zzaUF;

        private zzb(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzapc_zza) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
            this.zzaUF = com_google_android_gms_internal_zzapc_zza;
        }

        public void zzp(Status status) {
            if (this.zzaUF != null && status.isSuccess()) {
                this.zzaUF.zzBU();
            }
            this.zzaFq.setResult(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzapc_zza) {
        return googleApiClient.zzb(new C09894(this, googleApiClient, com_google_android_gms_internal_zzapc_zza, com_google_android_gms_fitness_data_zzu, pendingIntent));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent) {
        return googleApiClient.zza(new C09872(this, googleApiClient, sensorRequest, com_google_android_gms_fitness_data_zzu, pendingIntent));
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, null, pendingIntent);
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, com.google.android.gms.fitness.request.zzao.zza.zzCm().zza(onDataPointListener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza(new C09861(this, googleApiClient, dataSourcesRequest));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, OnDataPointListener onDataPointListener) {
        zzu zzb = com.google.android.gms.fitness.request.zzao.zza.zzCm().zzb(onDataPointListener);
        return zzb == null ? PendingResults.zza(Status.zzayh, googleApiClient) : zza(googleApiClient, zzb, null, new C09883(this, onDataPointListener));
    }
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzbm;
import com.google.android.gms.fitness.request.zzbq;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzzv.zzb;

public class zzapb implements RecordingApi {

    /* renamed from: com.google.android.gms.internal.zzapb.1 */
    class C09811 extends zza<ListSubscriptionsResult> {
        C09811(zzapb com_google_android_gms_internal_zzapb, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzY(Status status) {
            return ListSubscriptionsResult.zzag(status);
        }

        protected void zza(zzanv com_google_android_gms_internal_zzanv) throws RemoteException {
            ((zzaok) com_google_android_gms_internal_zzanv.zzwW()).zza(new zzam(null, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzY(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapb.2 */
    class C09822 extends zza<ListSubscriptionsResult> {
        final /* synthetic */ DataType zzaUr;

        C09822(zzapb com_google_android_gms_internal_zzapb, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzaUr = dataType;
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzY(Status status) {
            return ListSubscriptionsResult.zzag(status);
        }

        protected void zza(zzanv com_google_android_gms_internal_zzanv) throws RemoteException {
            ((zzaok) com_google_android_gms_internal_zzanv.zzwW()).zza(new zzam(this.zzaUr, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzY(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapb.3 */
    class C09833 extends zzc {
        final /* synthetic */ Subscription zzaUw;

        C09833(zzapb com_google_android_gms_internal_zzapb, GoogleApiClient googleApiClient, Subscription subscription) {
            this.zzaUw = subscription;
            super(googleApiClient);
        }

        protected void zza(zzanv com_google_android_gms_internal_zzanv) throws RemoteException {
            ((zzaok) com_google_android_gms_internal_zzanv.zzwW()).zza(new zzbm(this.zzaUw, false, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapb.4 */
    class C09844 extends zzc {
        final /* synthetic */ DataType zzaUr;

        C09844(zzapb com_google_android_gms_internal_zzapb, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzaUr = dataType;
            super(googleApiClient);
        }

        protected void zza(zzanv com_google_android_gms_internal_zzanv) throws RemoteException {
            ((zzaok) com_google_android_gms_internal_zzanv.zzwW()).zza(new zzbq(this.zzaUr, null, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapb.5 */
    class C09855 extends zzc {
        final /* synthetic */ DataSource zzaUx;

        C09855(zzapb com_google_android_gms_internal_zzapb, GoogleApiClient googleApiClient, DataSource dataSource) {
            this.zzaUx = dataSource;
            super(googleApiClient);
        }

        protected void zza(zzanv com_google_android_gms_internal_zzanv) throws RemoteException {
            ((zzaok) com_google_android_gms_internal_zzanv.zzwW()).zza(new zzbq(null, this.zzaUx, new zzape(this)));
        }
    }

    private static class zza extends com.google.android.gms.internal.zzaon.zza {
        private final zzb<ListSubscriptionsResult> zzaFq;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzaFq.setResult(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Subscription subscription) {
        return googleApiClient.zza(new C09833(this, googleApiClient, subscription));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C09811(this, googleApiClient));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.zza(new C09822(this, googleApiClient, dataType));
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzBM());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new com.google.android.gms.fitness.data.Subscription.zza().zzd(dataType).zzBM());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return googleApiClient.zzb(new C09855(this, googleApiClient, dataSource));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.zzb(new C09844(this, googleApiClient, dataType));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}

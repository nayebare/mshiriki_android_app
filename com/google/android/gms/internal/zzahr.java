package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzahr implements DriveResource {
    protected final DriveId zzaJj;

    private abstract class zzd extends zzahj<MetadataResult> {
        private zzd(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataResult zzS(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzS(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.1 */
    class C09461 extends zzd {
        final /* synthetic */ boolean zzaMd;
        final /* synthetic */ zzahr zzaMe;

        C09461(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient, boolean z) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            this.zzaMd = z;
            super(googleApiClient, null);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzaie(this.zzaMe.zzaJj, this.zzaMd), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.2 */
    class C09472 extends zzh {
        final /* synthetic */ zzahr zzaMe;

        C09472(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzaio(this.zzaMe.zzaJj), new zza(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.3 */
    class C09483 extends com.google.android.gms.internal.zzahj.zza {
        final /* synthetic */ zzahr zzaMe;
        final /* synthetic */ List zzaMf;

        C09483(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient, List list) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            this.zzaMf = list;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzakn(this.zzaMe.zzaJj, this.zzaMf), new zzakp(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.4 */
    class C09494 extends zzd {
        final /* synthetic */ MetadataChangeSet zzaLS;
        final /* synthetic */ zzahr zzaMe;

        C09494(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            this.zzaLS = metadataChangeSet;
            super(googleApiClient, null);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            this.zzaLS.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzala(this.zzaMe.zzaJj, this.zzaLS.zzzP()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.5 */
    class C09505 extends com.google.android.gms.internal.zzahj.zza {
        final /* synthetic */ zzahr zzaMe;

        C09505(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzahe(this.zzaMe.zzaJj), new zzakp(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.6 */
    class C09516 extends com.google.android.gms.internal.zzahj.zza {
        final /* synthetic */ zzahr zzaMe;

        C09516(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzaku(this.zzaMe.zzaJj), new zzakp(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahr.7 */
    class C09527 extends com.google.android.gms.internal.zzahj.zza {
        final /* synthetic */ zzahr zzaMe;

        C09527(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            this.zzaMe = com_google_android_gms_internal_zzahr;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzaky(this.zzaMe.zzaJj), new zzakp(this));
        }
    }

    private static class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzg(status, null, false));
        }

        public void zza(zzaji com_google_android_gms_internal_zzaji) throws RemoteException {
            this.zzaFq.setResult(new zzg(Status.zzayh, new MetadataBuffer(com_google_android_gms_internal_zzaji.zzAw()), false));
        }
    }

    private static class zzb extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<MetadataResult> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<MetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzc(status, null));
        }

        public void zza(zzajl com_google_android_gms_internal_zzajl) throws RemoteException {
            this.zzaFq.setResult(new zzc(Status.zzayh, new zzahd(com_google_android_gms_internal_zzajl.zzAx())));
        }
    }

    private static class zzc implements MetadataResult {
        private final Metadata zzaMg;
        private final Status zzahq;

        public zzc(Status status, Metadata metadata) {
            this.zzahq = status;
            this.zzaMg = metadata;
        }

        public Metadata getMetadata() {
            return this.zzaMg;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public zzahr(DriveId driveId) {
        this.zzaJj = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C09461(this, googleApiClient, z));
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zza(googleApiClient, this.zzaJj, changeListener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zza(googleApiClient, this.zzaJj);
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C09505(this, googleApiClient));
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C09472(this, googleApiClient));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zzb(googleApiClient, this.zzaJj, changeListener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zzb(googleApiClient, this.zzaJj);
    }

    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set != null) {
            return googleApiClient.zzb(new C09483(this, googleApiClient, new ArrayList(set)));
        }
        throw new IllegalArgumentException("ParentIds must be provided.");
    }

    public PendingResult<Status> trash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C09516(this, googleApiClient));
    }

    public PendingResult<Status> untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C09527(this, googleApiClient));
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.zzb(new C09494(this, googleApiClient, metadataChangeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}

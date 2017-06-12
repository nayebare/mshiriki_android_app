package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1 */
        class C08041 implements LoadSnapshotsResult {
            final /* synthetic */ Status zzamf;

            C08041(LoadImpl loadImpl, Status status) {
                this.zzamf = status;
            }

            public SnapshotMetadataBuffer getSnapshots() {
                return new SnapshotMetadataBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadSnapshotsResult zzaU(Status status) {
            return new C08041(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaU(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.1 */
    class C07961 extends LoadImpl {
        final /* synthetic */ boolean zzbaL;

        C07961(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzbaL);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1 */
        class C08051 implements OpenSnapshotResult {
            final /* synthetic */ Status zzamf;

            C08051(OpenImpl openImpl, Status status) {
                this.zzamf = status;
            }

            public String getConflictId() {
                return null;
            }

            public Snapshot getConflictingSnapshot() {
                return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
                return null;
            }

            public Snapshot getSnapshot() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult zzaV(Status status) {
            return new C08051(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaV(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.2 */
    class C07972 extends OpenImpl {
        final /* synthetic */ String zzbbl;
        final /* synthetic */ boolean zzbbm;
        final /* synthetic */ int zzbbn;

        C07972(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, String str, boolean z, int i) {
            this.zzbbl = str;
            this.zzbbm = z;
            this.zzbbn = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbl, this.zzbbm, this.zzbbn);
        }
    }

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1 */
        class C08021 implements CommitSnapshotResult {
            final /* synthetic */ Status zzamf;

            C08021(CommitImpl commitImpl, Status status) {
                this.zzamf = status;
            }

            public SnapshotMetadata getSnapshotMetadata() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult zzaS(Status status) {
            return new C08021(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaS(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.3 */
    class C07983 extends CommitImpl {
        final /* synthetic */ Snapshot zzbbo;
        final /* synthetic */ SnapshotMetadataChange zzbbp;

        C07983(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
            this.zzbbo = snapshot;
            this.zzbbp = snapshotMetadataChange;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbo, this.zzbbp);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1 */
        class C08031 implements DeleteSnapshotResult {
            final /* synthetic */ Status zzamf;

            C08031(DeleteImpl deleteImpl, Status status) {
                this.zzamf = status;
            }

            public String getSnapshotId() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult zzaT(Status status) {
            return new C08031(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaT(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.4 */
    class C07994 extends DeleteImpl {
        final /* synthetic */ SnapshotMetadata zzbbq;

        C07994(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
            this.zzbbq = snapshotMetadata;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzbbq.getSnapshotId());
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.5 */
    class C08005 extends OpenImpl {
        final /* synthetic */ SnapshotMetadataChange zzbbp;
        final /* synthetic */ String zzbbr;
        final /* synthetic */ String zzbbs;
        final /* synthetic */ SnapshotContents zzbbt;

        C08005(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
            this.zzbbr = str;
            this.zzbbs = str2;
            this.zzbbp = snapshotMetadataChange;
            this.zzbbt = snapshotContents;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbr, this.zzbbs, this.zzbbp, this.zzbbt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.6 */
    class C08016 extends LoadImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, null, false);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.zzb(new C07983(this, googleApiClient, snapshot, snapshotMetadataChange));
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return googleApiClient.zzb(new C07994(this, googleApiClient, snapshotMetadata));
    }

    public void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zzi(googleApiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEu();
    }

    public int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEt();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zzi(googleApiClient).zza(str, z, z2, i);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        return (bundle == null || !bundle.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) bundle.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C07961(this, googleApiClient, z));
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z, int i) {
        return googleApiClient.zzb(new C07972(this, googleApiClient, str, z, i));
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return googleApiClient.zzb(new C08005(this, googleApiClient, str, str2, snapshotMetadataChange, snapshotContents));
    }
}

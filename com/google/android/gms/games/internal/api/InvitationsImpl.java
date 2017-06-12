package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.internal.zzzv.zzb;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1 */
        class C07361 implements LoadInvitationsResult {
            final /* synthetic */ Status zzamf;

            C07361(LoadInvitationsImpl loadInvitationsImpl, Status status) {
                this.zzamf = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadInvitationsResult zzaw(Status status) {
            return new C07361(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaw(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.1 */
    class C07331 extends LoadInvitationsImpl {
        final /* synthetic */ int zzbaR;

        C07331(InvitationsImpl invitationsImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbaR = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaR);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.2 */
    class C07342 extends LoadInvitationsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.3 */
    class C07353 extends LoadInvitationsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this, null);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEh();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C07331(this, googleApiClient, i));
    }

    public void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zza(googleApiClient.zzr(onInvitationReceivedListener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEi();
        }
    }
}

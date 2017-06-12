package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C08311 implements LoadMatchResult {
            final /* synthetic */ Status zzamf;

            C08311(LoadMatchImpl loadMatchImpl, Status status) {
                this.zzamf = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzbc(Status status) {
            return new C08311(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbc(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ String zzbbv;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.zzbbv = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzbbv);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C08291 implements InitiateMatchResult {
            final /* synthetic */ Status zzamf;

            C08291(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.zzamf = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzba(Status status) {
            return new C08291(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzba(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, null);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C08321 implements LoadMatchesResult {
            final /* synthetic */ Status zzamf;

            C08321(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.zzamf = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzbd(Status status) {
            return new C08321(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbd(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, 0, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C08191 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig zzbbu;

        C08191(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.zzbbu = turnBasedMatchConfig;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbu);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C08202 extends InitiateMatchImpl {
        final /* synthetic */ String zzbbv;

        C08202(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.zzbbv = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzbbv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C08213 extends InitiateMatchImpl {
        final /* synthetic */ String zzbbw;

        C08213(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.zzbbw = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzbbw);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C08331 implements UpdateMatchResult {
            final /* synthetic */ Status zzamf;

            C08331(UpdateMatchImpl updateMatchImpl, Status status) {
                this.zzamf = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzbe(Status status) {
            return new C08331(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbe(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C08224 extends UpdateMatchImpl {
        final /* synthetic */ String zzbbv;
        final /* synthetic */ byte[] zzbbx;
        final /* synthetic */ String zzbby;
        final /* synthetic */ ParticipantResult[] zzbbz;

        C08224(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.zzbbv = str;
            this.zzbbx = bArr;
            this.zzbby = str2;
            this.zzbbz = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbv, this.zzbbx, this.zzbby, this.zzbbz);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C08235 extends UpdateMatchImpl {
        final /* synthetic */ String zzbbv;
        final /* synthetic */ byte[] zzbbx;
        final /* synthetic */ ParticipantResult[] zzbbz;

        C08235(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.zzbbv = str;
            this.zzbbx = bArr;
            this.zzbbz = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbv, this.zzbbx, this.zzbbz);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C08301 implements LeaveMatchResult {
            final /* synthetic */ Status zzamf;

            C08301(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.zzamf = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzbb(Status status) {
            return new C08301(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C08246 extends LeaveMatchImpl {
        final /* synthetic */ String zzbbv;

        C08246(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.zzbbv = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, this.zzbbv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C08257 extends LeaveMatchImpl {
        final /* synthetic */ String zzbbv;
        final /* synthetic */ String zzbby;

        C08257(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzbbv = str;
            this.zzbby = str2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbv, this.zzbby);
        }
    }

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzGu;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C08281 implements CancelMatchResult {
            final /* synthetic */ Status zzamf;
            final /* synthetic */ CancelMatchImpl zzbbC;

            C08281(CancelMatchImpl cancelMatchImpl, Status status) {
                this.zzbbC = cancelMatchImpl;
                this.zzamf = status;
            }

            public String getMatchId() {
                return this.zzbbC.zzGu;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public CancelMatchImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzGu = str;
        }

        public CancelMatchResult zzaZ(Status status) {
            return new C08281(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaZ(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C08268 extends CancelMatchImpl {
        final /* synthetic */ String zzbbv;

        C08268(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.zzbbv = str2;
            super(str, googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzbbv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C08279 extends LoadMatchesImpl {
        final /* synthetic */ int zzbbA;
        final /* synthetic */ int[] zzbbB;

        C08279(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, int i, int[] iArr) {
            this.zzbbA = i;
            this.zzbbB = iArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbA, this.zzbbB);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08213(this, googleApiClient, str));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08268(this, str, googleApiClient, str));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.zzb(new C08191(this, googleApiClient, turnBasedMatchConfig));
    }

    public void declineInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzq(str, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzp(str, 1);
        }
    }

    public void dismissMatch(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzeq(str);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, null, null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List<ParticipantResult> list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult... participantResultArr) {
        return googleApiClient.zzb(new C08235(this, googleApiClient, str, bArr, participantResultArr));
    }

    public Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEg();
    }

    public int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEp();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zzi(googleApiClient).zzb(i, i2, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zzi(googleApiClient).zzb(i, i2, z);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08246(this, googleApiClient, str));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new C08257(this, googleApiClient, str, str2));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new AnonymousClass10(this, googleApiClient, str));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int i, int[] iArr) {
        return googleApiClient.zza(new C08279(this, googleApiClient, i, iArr));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    public void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzb(googleApiClient.zzr(onTurnBasedMatchUpdateReceivedListener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08202(this, googleApiClient, str));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        return googleApiClient.zzb(new C08224(this, googleApiClient, str, bArr, str2, participantResultArr));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEj();
        }
    }
}

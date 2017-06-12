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
import com.google.android.gms.games.Games.StatusImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadStockProfileImagesResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.Players.UpdateGamerProfileResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.player.ProfileSettingsEntity;
import com.google.android.gms.internal.zzzv.zzb;

public final class PlayersImpl implements Players {

    static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C07701 implements LoadPlayersResult {
            final /* synthetic */ Status zzamf;

            C07701(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.zzamf = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzaF(Status status) {
            return new C07701(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaF(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C07611 extends LoadPlayersImpl {
        final /* synthetic */ String zzaul;

        C07611(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str) {
            this.zzaul = str;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaul, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, true, false);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C07721 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ Status zzamf;

            C07721(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public LoadXpForGameCategoriesResult zzaI(Status status) {
            return new C07721(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl((zzb) this, null);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C07731 implements LoadXpStreamResult {
            final /* synthetic */ Status zzamf;

            C07731(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public LoadXpStreamResult zzaJ(Status status) {
            return new C07731(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, 0);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult zzaG(Status status) {
            return new ProfileSettingsEntity(DataHolder.zzcD(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.27 */
    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, true);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.28 */
    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.29 */
    class AnonymousClass29 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C07622 extends LoadPlayersImpl {
        final /* synthetic */ String zzaul;
        final /* synthetic */ boolean zzbaL;

        C07622(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.zzaul = str;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaul, this.zzbaL);
        }
    }

    private static abstract class LoadStockProfileImagesImpl extends BaseGamesApiMethodImpl<LoadStockProfileImagesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadStockProfileImagesImpl.1 */
        class C07711 implements LoadStockProfileImagesResult {
            final /* synthetic */ Status zzamf;

            C07711(LoadStockProfileImagesImpl loadStockProfileImagesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        protected LoadStockProfileImagesResult zzaH(Status status) {
            return new C07711(this, status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaH(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.30 */
    class AnonymousClass30 extends LoadStockProfileImagesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this);
        }
    }

    private static abstract class UpdateGamerProfileImpl extends BaseGamesApiMethodImpl<UpdateGamerProfileResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.UpdateGamerProfileImpl.1 */
        class C07741 implements UpdateGamerProfileResult {
            final /* synthetic */ Status zzamf;

            C07741(UpdateGamerProfileImpl updateGamerProfileImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        protected UpdateGamerProfileResult zzaK(Status status) {
            return new C07741(this, status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.31 */
    class AnonymousClass31 extends UpdateGamerProfileImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, false, null, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.32 */
    class AnonymousClass32 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.33 */
    class AnonymousClass33 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.34 */
    class AnonymousClass34 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C07633 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C07644 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ int zzbbd;

        C07644(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.zzbbd = i;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbd, false, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C07655 extends LoadPlayersImpl {
        final /* synthetic */ int zzbbd;

        C07655(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbbd = i;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbd, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C07666 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ int zzbbd;

        C07666(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.zzbbd = i;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzbbd, false, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C07677 extends LoadPlayersImpl {
        final /* synthetic */ int zzbbd;

        C07677(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbbd = i;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzbbd, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C07688 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;

        C07688(PlayersImpl playersImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C07699 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzi(googleApiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEc();
    }

    public String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzax(true);
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEm();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C07688(this, googleApiClient, z));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.zza(new C07644(this, googleApiClient, i, z));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C07655(this, googleApiClient, i));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C07677(this, googleApiClient, i));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C07611(this, googleApiClient, str));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.zza(new C07622(this, googleApiClient, str, z));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.zza(new C07666(this, googleApiClient, i, z));
    }
}

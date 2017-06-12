package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C07321 implements LoadGamesResult {
            final /* synthetic */ Status zzamf;

            C07321(LoadGamesImpl loadGamesImpl, Status status) {
                this.zzamf = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult zzav(Status status) {
            return new C07321(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzav(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C07271 extends LoadGamesImpl {
        C07271(GamesMetadataImpl gamesMetadataImpl, GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C07301 implements LoadGameInstancesResult {
            final /* synthetic */ Status zzamf;

            C07301(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadGameInstancesResult zzat(Status status) {
            return new C07301(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzat(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C07282 extends LoadGameInstancesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj((zzb) this, null);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C07311 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ Status zzamf;

            C07311(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadGameSearchSuggestionsResult zzau(Status status) {
            return new C07311(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzau(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C07293 extends LoadGameSearchSuggestionsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk((zzb) this, null);
        }
    }

    public Game getCurrentGame(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEd();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C07271(this, googleApiClient));
    }
}

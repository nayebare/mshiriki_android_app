package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.SocialImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.social.Social;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events;
    public static final GamesMetadata GamesMetadata;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final Quests Quests;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final Snapshots Snapshots;
    public static final Stats Stats;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    public static final Videos Videos;
    private static final zza<GamesClientImpl, GamesOptions> zzaXo;
    public static final Scope zzaXp;
    public static final Api<GamesOptions> zzaXq;
    public static final AppContents zzaXr;
    public static final Multiplayer zzaXs;
    public static final Social zzaXt;
    static final zzf<GamesClientImpl> zzahc;
    private static final zza<GamesClientImpl, GamesOptions> zzahd;

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzg, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.1 */
    class C06931 extends GamesClientBuilder {
        C06931() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzp(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    class C06942 extends GamesClientBuilder {
        C06942() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzaXp);
        }

        public /* synthetic */ List zzp(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zzzv.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzahc, googleApiClient);
        }
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {

        /* renamed from: com.google.android.gms.games.Games.GetTokenImpl.1 */
        class C07011 implements GetTokenResult {
            final /* synthetic */ Status zzamf;

            C07011(GetTokenImpl getTokenImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public GetTokenResult zzak(Status status) {
            return new C07011(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzak(status);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.3 */
    class C06953 extends GetTokenImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this);
        }
    }

    private static abstract class GetServerAuthCodeImpl extends BaseGamesApiMethodImpl<GetServerAuthCodeResult> {

        /* renamed from: com.google.android.gms.games.Games.GetServerAuthCodeImpl.1 */
        class C07001 implements GetServerAuthCodeResult {
            final /* synthetic */ Status zzamf;

            C07001(GetServerAuthCodeImpl getServerAuthCodeImpl, Status status) {
                this.zzamf = status;
            }

            public String getCode() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private GetServerAuthCodeImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public GetServerAuthCodeResult zzaj(Status status) {
            return new C07001(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaj(status);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.4 */
    class C06964 extends GetServerAuthCodeImpl {
        final /* synthetic */ String zzaXu;

        C06964(GoogleApiClient googleApiClient, String str) {
            this.zzaXu = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this.zzaXu, (zzb) this);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.5 */
    class C06975 extends SignOutImpl {
        C06975(GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.6 */
    class C06986 extends BaseGamesApiMethodImpl<Status> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, null);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.7 */
    class C06997 extends BaseGamesApiMethodImpl<Status> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(null);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static final class GamesOptions implements Optional {
        public final String zzaXA;
        public final ArrayList<String> zzaXB;
        public final boolean zzaXC;
        public final boolean zzaXD;
        public final boolean zzaXv;
        public final boolean zzaXw;
        public final int zzaXx;
        public final boolean zzaXy;
        public final int zzaXz;

        public static final class Builder {
            String zzaXA;
            ArrayList<String> zzaXB;
            boolean zzaXC;
            boolean zzaXD;
            boolean zzaXv;
            boolean zzaXw;
            int zzaXx;
            boolean zzaXy;
            int zzaXz;

            private Builder() {
                this.zzaXv = false;
                this.zzaXw = true;
                this.zzaXx = 17;
                this.zzaXy = false;
                this.zzaXz = 4368;
                this.zzaXA = null;
                this.zzaXB = new ArrayList();
                this.zzaXC = false;
                this.zzaXD = false;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            @Deprecated
            public Builder setRequireGooglePlus(boolean z) {
                this.zzaXC = z;
                return this;
            }

            public Builder setSdkVariant(int i) {
                this.zzaXz = i;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zzaXw = z;
                this.zzaXx = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int i) {
                this.zzaXw = z;
                this.zzaXx = i;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaXv = false;
            this.zzaXw = true;
            this.zzaXx = 17;
            this.zzaXy = false;
            this.zzaXz = 4368;
            this.zzaXA = null;
            this.zzaXB = new ArrayList();
            this.zzaXC = false;
            this.zzaXD = false;
        }

        private GamesOptions(Builder builder) {
            this.zzaXv = false;
            this.zzaXw = builder.zzaXw;
            this.zzaXx = builder.zzaXx;
            this.zzaXy = false;
            this.zzaXz = builder.zzaXz;
            this.zzaXA = null;
            this.zzaXB = builder.zzaXB;
            this.zzaXC = builder.zzaXC;
            this.zzaXD = false;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzDb() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaXw);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaXx);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaXz);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaXB);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzaXC);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
            return bundle;
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    public interface GetTokenResult extends Result {
    }

    public static abstract class StatusImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C06931();
        zzaXo = new C06942();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api("Games.API", zzahd, zzahc);
        zzaXp = new Scope("https://www.googleapis.com/auth/games.firstparty");
        zzaXq = new Api("Games.API_1P", zzaXo, zzahc);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        zzaXr = new AppContentsImpl();
        Events = new EventsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        zzaXs = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Quests = new QuestsImpl();
        Requests = new RequestsImpl();
        Snapshots = new SnapshotsImpl();
        Stats = new StatsImpl();
        Videos = new VideosImpl();
        zzaXt = new SocialImpl();
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzjI();
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEb();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        zzac.zzh(str, "Please provide a valid serverClientId");
        return googleApiClient.zzb(new C06964(googleApiClient, str));
    }

    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEo();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEn();
    }

    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zziy(i);
        }
    }

    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        zzac.zzw(view);
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzv(view);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C06975(googleApiClient));
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzac.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzahc) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzi(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}

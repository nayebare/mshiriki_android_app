package com.google.android.gms.games.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GetServerAuthCodeResult;
import com.google.android.gms.games.Games.GetTokenResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadStockProfileImagesResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.Players.UpdateGamerProfileResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.player.ProfileSettingsEntity;
import com.google.android.gms.games.internal.player.StockProfileImageBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.social.OnSocialInviteUpdateReceivedListener;
import com.google.android.gms.games.social.Social.InviteUpdateResult;
import com.google.android.gms.games.social.Social.LoadInvitesResult;
import com.google.android.gms.games.social.SocialInvite;
import com.google.android.gms.games.social.SocialInviteBuffer;
import com.google.android.gms.games.social.SocialInviteEntity;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos.CaptureRuntimeErrorCallback;
import com.google.android.gms.games.video.Videos.CaptureStateResult;
import com.google.android.gms.games.video.Videos.CaptureStoppedResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingAvailabilityResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingMetadataResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingUrlResult;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzaag;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzaaz.zzc;
import com.google.android.gms.internal.zzaxy;
import com.google.android.gms.internal.zzzv.zzb;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class GamesClientImpl extends zzl<IGamesService> {
    EventIncrementManager zzaYP;
    private final String zzaYQ;
    private PlayerEntity zzaYR;
    private GameEntity zzaYS;
    private final PopupManager zzaYT;
    private boolean zzaYU;
    private final Binder zzaYV;
    private final long zzaYW;
    private final GamesOptions zzaYX;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl.1 */
    class C07071 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzaYY;

        C07071(GamesClientImpl gamesClientImpl) {
            this.zzaYY = gamesClientImpl;
        }

        public EventIncrementCache zzEz() {
            return new GameClientEventIncrementCache(this.zzaYY);
        }
    }

    private static abstract class AbstractRoomStatusNotifier extends zzaaf<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzai(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzaYZ;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            this.zzaYZ = new ArrayList();
            for (Object add : strArr) {
                this.zzaYZ.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaYZ);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zzaaf<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzai(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static final class AcceptFriendInviteFirstPartyBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InviteUpdateResult> zzaFq;

        AcceptFriendInviteFirstPartyBinderCallback(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, (Object) "Holder must not be null");
        }

        public void zzaa(DataHolder dataHolder) {
            this.zzaFq.setResult(new InviteUpdateResultImpl(dataHolder));
        }
    }

    private static abstract class GamesDataHolderResult extends zzaag {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzib(dataHolder.getStatusCode()));
        }
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzaZa;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaZa = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaZa = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaZa;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<UpdateAchievementResult> zzaFq;

        AchievementUpdatedBinderCallback(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzaFq.setResult(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadAchievementsResult> zzaFq;

        AchievementsLoadedBinderCallback(zzb<LoadAchievementsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadAppContentResult> zzaZb;

        public AppContentLoadedBinderCallbacks(zzb<LoadAppContentResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult) {
            this.zzaZb = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaZb.setResult(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelFriendInviteFirstPartyBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InviteUpdateResult> zzaFq;

        CancelFriendInviteFirstPartyBinderCallback(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, (Object) "Holder must not be null");
        }

        public void zzae(DataHolder dataHolder) {
            this.zzaFq.setResult(new InviteUpdateResultImpl(dataHolder));
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final String zzaZc;
        private final Status zzahq;

        CancelMatchResultImpl(Status status, String str) {
            this.zzahq = status;
            this.zzaZc = str;
        }

        public String getMatchId() {
            return this.zzaZc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureAvailableBinderCallback extends AbstractGamesCallbacks {
        private final zzb<CaptureAvailableResult> zzaFq;

        CaptureAvailableBinderCallback(zzb<CaptureAvailableResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureAvailableResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureAvailableResult, (Object) "Holder must not be null");
        }

        public void zzd(int i, boolean z) {
            this.zzaFq.setResult(new CaptureAvailableResultImpl(new Status(i), z));
        }
    }

    private static final class CaptureAvailableResultImpl implements CaptureAvailableResult {
        private final boolean zzaZd;
        private final Status zzahq;

        CaptureAvailableResultImpl(Status status, boolean z) {
            this.zzahq = status;
            this.zzaZd = z;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public boolean isAvailable() {
            return this.zzaZd;
        }
    }

    private static final class CaptureCapabilitiesBinderCallback extends AbstractGamesCallbacks {
        private final zzb<CaptureCapabilitiesResult> zzaFq;

        CaptureCapabilitiesBinderCallback(zzb<CaptureCapabilitiesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureCapabilitiesResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureCapabilitiesResult, (Object) "Holder must not be null");
        }

        public void zza(int i, VideoCapabilities videoCapabilities) {
            this.zzaFq.setResult(new CaptureCapabilitiesResultImpl(new Status(i), videoCapabilities));
        }
    }

    private static final class CaptureCapabilitiesResultImpl implements CaptureCapabilitiesResult {
        private final VideoCapabilities zzaZe;
        private final Status zzahq;

        CaptureCapabilitiesResultImpl(Status status, VideoCapabilities videoCapabilities) {
            this.zzahq = status;
            this.zzaZe = videoCapabilities;
        }

        public VideoCapabilities getCapabilities() {
            return this.zzaZe;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureLaunchGameAndOverlayBinderCallback extends AbstractGamesCallbacks {
        private final BaseGamesApiMethodImpl<Status> zzaZf;

        CaptureLaunchGameAndOverlayBinderCallback(BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl) {
            this.zzaZf = (BaseGamesApiMethodImpl) zzac.zzb((Object) baseGamesApiMethodImpl, (Object) "Holder must not be null");
        }

        public void zzal(Status status) {
            this.zzaZf.zzb(status);
        }

        public void zziq(int i) {
            this.zzaZf.zzb(new Status(i));
        }
    }

    private static final class CaptureOverlayStateBinderCallback extends AbstractGamesCallbacks {
        private final zzaaz<CaptureOverlayStateListener> zzaLP;

        CaptureOverlayStateBinderCallback(zzaaz<CaptureOverlayStateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_video_Videos_CaptureOverlayStateListener) {
            this.zzaLP = (zzaaz) zzac.zzb((Object) com_google_android_gms_internal_zzaaz_com_google_android_gms_games_video_Videos_CaptureOverlayStateListener, (Object) "Callback must not be null");
        }

        public void onCaptureOverlayStateChanged(int i) {
            this.zzaLP.zza(new CaptureOverlayStateChangedNotifier(i));
        }
    }

    private static final class CaptureOverlayStateChangedNotifier implements zzc<CaptureOverlayStateListener> {
        private final int zzaZg;

        CaptureOverlayStateChangedNotifier(int i) {
            this.zzaZg = i;
        }

        public void zza(CaptureOverlayStateListener captureOverlayStateListener) {
            captureOverlayStateListener.onCaptureOverlayStateChanged(this.zzaZg);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((CaptureOverlayStateListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class CapturePausedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        public CapturePausedBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zziw(int i) {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class CaptureStartedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;
        private final CaptureRuntimeErrorCallback zzaZh;

        public CaptureStartedBinderCallbacks(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, CaptureRuntimeErrorCallback captureRuntimeErrorCallback) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
            this.zzaZh = (CaptureRuntimeErrorCallback) zzac.zzb((Object) captureRuntimeErrorCallback, (Object) "Callback must not be null");
        }

        public void zzao(Status status) {
            this.zzaFq.setResult(status);
        }

        public void zziv(int i) {
        }
    }

    private static final class CaptureStateBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CaptureStateResult> zzaFq;

        public CaptureStateBinderCallbacks(zzb<CaptureStateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStateResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStateResult, (Object) "Holder must not be null");
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaFq.setResult(new CaptureStateResultImpl(new Status(i), CaptureState.zzC(bundle)));
        }
    }

    private static final class CaptureStateResultImpl implements CaptureStateResult {
        private final CaptureState zzaZi;
        private final Status zzahq;

        CaptureStateResultImpl(Status status, CaptureState captureState) {
            this.zzahq = status;
            this.zzaZi = captureState;
        }

        public CaptureState getCaptureState() {
            return this.zzaZi;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureStoppedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CaptureStoppedResult> zzaFq;

        public CaptureStoppedBinderCallbacks(zzb<CaptureStoppedResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStoppedResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStoppedResult, (Object) "Holder must not be null");
        }

        public void zza(int i, Uri uri) {
            this.zzaFq.setResult(new CaptureStoppedResultImpl(new Status(i), uri));
        }
    }

    private static final class CaptureStoppedResultImpl implements CaptureStoppedResult {
        private final Uri zzaZj;
        private final Status zzahq;

        CaptureStoppedResultImpl(Status status, Uri uri) {
            this.zzahq = status;
            this.zzaZj = uri;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureStreamingAvailabilityBinderCallback extends AbstractGamesCallbacks {
        private final zzb<CaptureStreamingAvailabilityResult> zzaFq;

        CaptureStreamingAvailabilityBinderCallback(zzb<CaptureStreamingAvailabilityResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingAvailabilityResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingAvailabilityResult, (Object) "Holder must not be null");
        }

        public void zza(int i, boolean z, boolean z2) {
            this.zzaFq.setResult(new CaptureStreamingAvailabilityResultImpl(new Status(i), z, z2));
        }
    }

    private static final class CaptureStreamingAvailabilityResultImpl implements CaptureStreamingAvailabilityResult {
        private final boolean zzaZd;
        private final boolean zzaZk;
        private final Status zzahq;

        CaptureStreamingAvailabilityResultImpl(Status status, boolean z, boolean z2) {
            this.zzahq = status;
            this.zzaZd = z;
            this.zzaZk = z2;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureStreamingEnabledBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        CaptureStreamingEnabledBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzir(int i) {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class CaptureStreamingEnabledResultImpl implements Result {
        private final Status zzahq;

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureStreamingMetadataBinderCallback extends AbstractGamesCallbacks {
        private final zzb<CaptureStreamingMetadataResult> zzaFq;

        CaptureStreamingMetadataBinderCallback(zzb<CaptureStreamingMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingMetadataResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingMetadataResult, (Object) "Holder must not be null");
        }

        public void zzd(int i, String str, String str2) {
            this.zzaFq.setResult(new CaptureStreamingMetadataResultImpl(new Status(i), str, str2));
        }
    }

    private static final class CaptureStreamingMetadataResultImpl implements CaptureStreamingMetadataResult {
        private final String zzacd;
        private final Status zzahq;
        private final String zzalD;

        CaptureStreamingMetadataResultImpl(Status status, String str, String str2) {
            this.zzahq = status;
            this.zzalD = str;
            this.zzacd = str2;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class CaptureStreamingUrlBinderCallback extends AbstractGamesCallbacks {
        private final zzb<CaptureStreamingUrlResult> zzaFq;

        CaptureStreamingUrlBinderCallback(zzb<CaptureStreamingUrlResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingUrlResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingUrlResult, (Object) "Holder must not be null");
        }

        public void zzl(int i, String str) {
            this.zzaFq.setResult(new CaptureStreamingUrlResultImpl(new Status(i), str));
        }
    }

    private static final class CaptureStreamingUrlResultImpl implements CaptureStreamingUrlResult {
        private final String zzD;
        private final Status zzahq;

        CaptureStreamingUrlResultImpl(Status status, String str) {
            this.zzahq = status;
            this.zzD = str;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public String getUrl() {
            return this.zzD;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzaZa;
        private final Milestone zzaZl;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaZa = new QuestEntity((Quest) questBuffer.get(0));
                    List zzFI = this.zzaZa.zzFI();
                    int size = zzFI.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzFI.get(i)).getMilestoneId().equals(str)) {
                            this.zzaZl = (Milestone) zzFI.get(i);
                            return;
                        }
                    }
                    this.zzaZl = null;
                } else {
                    this.zzaZl = null;
                    this.zzaZa = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaZl;
        }

        public Quest getQuest() {
            return this.zzaZa;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzaZm;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaZm = new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaZm = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaZm;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<ContactSettingLoadResult> zzaFq;

        ContactSettingsLoadedBinderCallback(zzb<ContactSettingLoadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzaFq.setResult(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        ContactSettingsUpdatedBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzio(int i) {
            this.zzaFq.setResult(GamesStatusCodes.zzib(i));
        }
    }

    private static final class DeletePlayerBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        DeletePlayerBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzis(int i) {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final String zzaZn;
        private final Status zzahq;

        DeleteSnapshotResultImpl(int i, String str) {
            this.zzahq = GamesStatusCodes.zzib(i);
            this.zzaZn = str;
        }

        public String getSnapshotId() {
            return this.zzaZn;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadEventsResult> zzaFq;

        EventsLoadedBinderCallback(zzb<LoadEventsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadEventResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzaYY;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzaYY = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), CardNetwork.OTHER);
        }

        protected void zzr(String str, int i) {
            try {
                if (this.zzaYY.isConnected()) {
                    ((IGamesService) this.zzaYY.zzwW()).zzo(str, i);
                } else {
                    GamesLog.zzF("GamesClientImpl", new StringBuilder(String.valueOf(str).length() + 89).append("Unable to increment event ").append(str).append(" by ").append(i).append(" because the games client is no longer connected").toString());
                }
            } catch (RemoteException e) {
                this.zzaYY.zzd(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGameInstancesResult> zzaFq;

        GameInstancesLoadedBinderCallback(zzb<LoadGameInstancesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final boolean zzZA;
        private final String zzaZo;
        private final Status zzahq;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.zzahq = GamesStatusCodes.zzib(i);
            this.zzaZo = str;
            this.zzZA = z;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<GameMuteStatusChangeResult> zzaFq;

        GameMuteStatusChangedBinderCallback(zzb<GameMuteStatusChangeResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzaFq.setResult(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final boolean zzZA;
        private final String zzaZo;
        private final Status zzahq;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzahq = GamesStatusCodes.zzib(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaZo = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzZA = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaZo = null;
                    this.zzZA = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<GameMuteStatusLoadResult> zzaFq;

        GameMuteStatusLoadedBinderCallback(zzb<GameMuteStatusLoadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzaFq.setResult(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGameSearchSuggestionsResult> zzaFq;

        GameSearchSuggestionsLoadedBinderCallback(zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamerProfileUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<UpdateGamerProfileResult> zzaFq;

        GamerProfileUpdatedBinderCallback(zzb<UpdateGamerProfileResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_UpdateGamerProfileResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_UpdateGamerProfileResult;
        }

        public void zzh(int i, Bundle bundle) {
            this.zzaFq.setResult(new UpdateGamerProfileResultImpl(i, bundle));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGamesResult> zzaFq;

        GamesLoadedBinderCallback(zzb<LoadGamesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<GetTokenResult> zzaFq;

        public GetAuthTokenBinderCallbacks(zzb<GetTokenResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetTokenResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetTokenResult, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzaFq.setResult(new GetTokenResultImpl(GamesStatusCodes.zzib(i), str));
        }
    }

    private static final class GetServerAuthCodeBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<GetServerAuthCodeResult> zzaFq;

        public GetServerAuthCodeBinderCallbacks(zzb<GetServerAuthCodeResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzaFq.setResult(new GetServerAuthCodeResultImpl(GamesStatusCodes.zzib(i), str));
        }
    }

    private static final class GetServerAuthCodeResultImpl implements GetServerAuthCodeResult {
        private final String zzaZp;
        private final Status zzahq;

        GetServerAuthCodeResultImpl(Status status, String str) {
            this.zzahq = status;
            this.zzaZp = str;
        }

        public String getCode() {
            return this.zzaZp;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class GetTokenResultImpl implements GetTokenResult {
        private final String zzahI;
        private final Status zzahq;

        GetTokenResultImpl(Status status, String str) {
            this.zzahq = status;
            this.zzahI = str;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class HeadlessCaptureEnabledBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        HeadlessCaptureEnabledBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzam(Status status) {
            this.zzaFq.setResult(status);
        }
    }

    private static final class IgnoreFriendInviteFirstPartyBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InviteUpdateResult> zzaFq;

        IgnoreFriendInviteFirstPartyBinderCallback(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, (Object) "Holder must not be null");
        }

        public void zzad(DataHolder dataHolder) {
            this.zzaFq.setResult(new InviteUpdateResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Bundle zzaZq;
        private final Status zzahq;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.zzahq = status;
            this.zzaZq = bundle;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InboxCountResult> zzaFq;

        InboxCountsLoadedBinderCallback(zzb<InboxCountResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_InboxCountResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_InboxCountResult, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFq.setResult(new InboxCountResultImpl(GamesStatusCodes.zzib(i), bundle));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaZQ;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaZQ = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaZQ = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaZQ;
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzaaz<OnInvitationReceivedListener> zzaLP;

        InvitationReceivedBinderCallback(zzaaz<OnInvitationReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener;
        }

        public void onInvitationRemoved(String str) {
            this.zzaLP.zza(new InvitationRemovedNotifier(str));
        }

        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzaLP.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzc<OnInvitationReceivedListener> {
        private final Invitation zzaZr;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaZr = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaZr);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class InvitationRemovedNotifier implements zzc<OnInvitationReceivedListener> {
        private final String zzahi;

        InvitationRemovedNotifier(String str) {
            this.zzahi = str;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzahi);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadInvitationsResult> zzaFq;

        InvitationsLoadedBinderCallback(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class InviteUpdateResultImpl extends GamesDataHolderResult implements InviteUpdateResult {
        private final SocialInvite zzaZs;

        InviteUpdateResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SocialInviteBuffer socialInviteBuffer = new SocialInviteBuffer(dataHolder);
            try {
                if (socialInviteBuffer.getCount() > 0) {
                    this.zzaZs = new SocialInviteEntity((SocialInvite) socialInviteBuffer.get(0));
                } else {
                    this.zzaZs = null;
                }
                socialInviteBuffer.release();
            } catch (Throwable th) {
                socialInviteBuffer.release();
            }
        }
    }

    private static final class InvitesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadInvitesResult> zzaFq;

        InvitesLoadedBinderCallback(zzb<LoadInvitesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_LoadInvitesResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_LoadInvitesResult, (Object) "Holder must not be null");
        }

        public void zzah(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadInvitesResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaZt;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZt = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzaZt;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadScoresResult> zzaFq;

        LeaderboardScoresLoadedBinderCallback(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzaFq.setResult(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LeaderboardMetadataResult> zzaFq;

        LeaderboardsLoadedBinderCallback(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzaFq.setResult(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements zzc<RoomUpdateListener> {
        private final String zzaZu;
        private final int zzauz;

        LeftRoomNotifier(int i, String str) {
            this.zzauz = i;
            this.zzaZu = str;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzauz, this.zzaZu);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomUpdateListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zzb<ListVideosResult> zzaFq;

        ListVideosBinderCallback(zzb<ListVideosResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult, (Object) "Holder must not be null");
        }

        public void zzX(DataHolder dataHolder) {
            this.zzaFq.setResult(new ListVideosResultImpl(dataHolder));
        }
    }

    private static final class ListVideosResultImpl extends GamesDataHolderResult implements ListVideosResult {
        private final VideoBuffer zzaZv;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZv = new VideoBuffer(dataHolder);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzaZw;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZw = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaZw;
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzaZx;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.zzaZx = new ArrayList(Arrays.asList(dataHolderArr));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzaZy;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZy = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaZy;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzaZz;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZz = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaZA;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZA = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzaZB;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZB = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaZB;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzaZC;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZC = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaZC;
        }
    }

    private static final class LoadInvitesResultImpl extends GamesDataHolderResult implements LoadInvitesResult {
        private final SocialInviteBuffer zzaZD;

        LoadInvitesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZD = new SocialInviteBuffer(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final LoadMatchesResponse zzaZE;
        private final Status zzahq;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.zzahq = status;
            this.zzaZE = new LoadMatchesResponse(bundle);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaZE;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public void release() {
            this.zzaZE.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaZF;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaZF = (LeaderboardScoreEntity) ((LeaderboardScore) leaderboardScoreBuffer.get(0)).freeze();
                } else {
                    this.zzaZF = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaZF;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements LoadPlayerStatsResult {
        private final PlayerStats zzaZG;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaZG = new PlayerStatsEntity((PlayerStats) playerStatsBuffer.get(0));
                } else {
                    this.zzaZG = null;
                }
                playerStatsBuffer.release();
            } catch (Throwable th) {
                playerStatsBuffer.release();
            }
        }

        public PlayerStats getPlayerStats() {
            return this.zzaZG;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzaZH;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZH = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaZH;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzazI;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzazI = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzazI);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Bundle zzaZI;
        private final Status zzahq;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.zzahq = status;
            this.zzaZI = bundle;
        }

        public GameRequestBuffer getRequests(int i) {
            String zziC = RequestType.zziC(i);
            return !this.zzaZI.containsKey(zziC) ? null : new GameRequestBuffer((DataHolder) this.zzaZI.get(zziC));
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public void release() {
            for (String parcelable : this.zzaZI.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaZI.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzaZJ;
        private final LeaderboardScoreBuffer zzaZK;

        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaZJ = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaZJ = null;
                }
                leaderboardBuffer.release();
                this.zzaZK = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaZJ;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaZK;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzazI);
        }
    }

    private static final class LoadStockProfileImagesResultImpl extends GamesDataHolderResult implements LoadStockProfileImagesResult {
        private final StockProfileImageBuffer zzaZL;

        LoadStockProfileImagesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZL = new StockProfileImageBuffer(dataHolder);
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final List<String> zzaZM;
        private final Bundle zzaZN;
        private final Status zzahq;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.zzahq = status;
            this.zzaZM = bundle.getStringArrayList("game_category_list");
            this.zzaZN = bundle;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaZO;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaZO = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements zzc<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaZP;

        MatchRemovedNotifier(String str) {
            this.zzaZP = str;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaZP);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzaaz<OnTurnBasedMatchUpdateReceivedListener> zzaLP;

        MatchUpdateReceivedBinderCallback(zzaaz<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String str) {
            this.zzaLP.zza(new MatchRemovedNotifier(str));
        }

        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzaLP.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzc<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaZQ;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.zzaZQ = turnBasedMatch;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaZQ);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class MessageReceivedNotifier implements zzc<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaZR;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.zzaZR = realTimeMessage;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaZR);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzc<OnNearbyPlayerDetectedListener> {
        public /* bridge */ /* synthetic */ void zzs(Object obj) {
        }

        public void zzvy() {
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzaZS;
        private final String zzaZT;
        private final Snapshot zzaZU;
        private final com.google.android.gms.drive.zzc zzaZV;
        private final SnapshotContents zzaZW;

        OpenSnapshotResultImpl(DataHolder dataHolder, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc) {
            this(dataHolder, null, com_google_android_gms_drive_zzc, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataHolder, String str, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc2, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc3) {
            boolean z = true;
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaZS = null;
                    this.zzaZU = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (dataHolder.getStatusCode() == GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzc.zzar(z);
                    this.zzaZS = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(com_google_android_gms_drive_zzc));
                    this.zzaZU = null;
                } else {
                    this.zzaZS = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(com_google_android_gms_drive_zzc));
                    this.zzaZU = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(com_google_android_gms_drive_zzc2));
                }
                snapshotMetadataBuffer.release();
                this.zzaZT = str;
                this.zzaZV = com_google_android_gms_drive_zzc3;
                this.zzaZW = new SnapshotContentsEntity(com_google_android_gms_drive_zzc3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzaZT;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaZU;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaZW;
        }

        public Snapshot getSnapshot() {
            return this.zzaZS;
        }
    }

    private static final class P2PConnectedNotifier implements zzc<RoomStatusUpdateListener> {
        private final String zzaZX;

        P2PConnectedNotifier(String str) {
            this.zzaZX = str;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaZX);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class P2PDisconnectedNotifier implements zzc<RoomStatusUpdateListener> {
        private final String zzaZX;

        P2PDisconnectedNotifier(String str) {
            this.zzaZX = str;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaZX);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayerScoreResult> zzaFq;

        PlayerLeaderboardScoreLoadedBinderCallback(zzb<LoadPlayerScoreResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadPlayerStatsResult> zzaFq;

        public PlayerStatsLoadedBinderCallbacks(zzb<LoadPlayerStatsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, (Object) "Holder must not be null");
        }

        public void zzW(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerUnfriendedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayersResult> zzaFq;

        PlayerUnfriendedBinderCallback(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, (Object) "Holder must not be null");
        }

        public void zzaf(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadXpForGameCategoriesResult> zzaFq;

        PlayerXpForGameCategoriesLoadedBinderCallback(zzb<LoadXpForGameCategoriesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFq.setResult(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzib(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadXpStreamResult> zzaFq;

        PlayerXpStreamLoadedBinderCallback(zzb<LoadXpStreamResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayersResult> zzaFq;

        PlayersLoadedBinderCallback(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzm(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaYT;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaYT = popupManager;
        }

        public PopupLocationInfoParcelable zzDX() {
            return new PopupLocationInfoParcelable(this.zzaYT.zzEQ());
        }
    }

    private static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadProfileSettingsResult> zzaFq;

        ProfileSettingsLoadedBinderCallback(zzb<LoadProfileSettingsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult;
        }

        public void zzV(DataHolder dataHolder) {
            this.zzaFq.setResult(new ProfileSettingsEntity(dataHolder));
            dataHolder.close();
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        ProfileSettingsUpdatedBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzip(int i) {
            this.zzaFq.setResult(GamesStatusCodes.zzib(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<AcceptQuestResult> zzaZY;

        public QuestAcceptedBinderCallbacks(zzb<AcceptQuestResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult) {
            this.zzaZY = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzaZY.setResult(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements zzc<QuestUpdateListener> {
        private final Quest zzaZa;

        QuestCompletedNotifier(Quest quest) {
            this.zzaZa = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaZa);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((QuestUpdateListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<ClaimMilestoneResult> zzaZZ;
        private final String zzbaa;

        public QuestMilestoneClaimBinderCallbacks(zzb<ClaimMilestoneResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str) {
            this.zzaZZ = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, (Object) "Holder must not be null");
            this.zzbaa = (String) zzac.zzb((Object) str, (Object) "MilestoneId must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzaZZ.setResult(new ClaimMilestoneResultImpl(dataHolder, this.zzbaa));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzaaz<QuestUpdateListener> zzaLP;

        QuestUpdateBinderCallback(zzaaz<QuestUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_quest_QuestUpdateListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_quest_QuestUpdateListener;
        }

        private Quest zzak(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzR(DataHolder dataHolder) {
            Quest zzak = zzak(dataHolder);
            if (zzak != null) {
                this.zzaLP.zza(new QuestCompletedNotifier(zzak));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadQuestsResult> zzbab;

        public QuestsLoadedBinderCallbacks(zzb<LoadQuestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult) {
            this.zzbab = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzbab.setResult(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzc<ReliableMessageSentCallback> {
        private final int zzauz;
        private final String zzbac;
        private final int zzbad;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.zzauz = i;
            this.zzbad = i2;
            this.zzbac = str;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzauz, this.zzbad, this.zzbac);
            }
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }

        public void zzvy() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzaaz<ReliableMessageSentCallback> zzbae;

        public RealTimeReliableMessageBinderCallbacks(zzaaz<ReliableMessageSentCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback) {
            this.zzbae = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzbae != null) {
                this.zzbae.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzaaz<OnRequestReceivedListener> zzaLP;

        RequestReceivedBinderCallback(zzaaz<OnRequestReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_request_OnRequestReceivedListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_request_OnRequestReceivedListener;
        }

        public void onRequestRemoved(String str) {
            this.zzaLP.zza(new RequestRemovedNotifier(str));
        }

        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzaLP.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestReceivedNotifier implements zzc<OnRequestReceivedListener> {
        private final GameRequest zzbaf;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.zzbaf = gameRequest;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzbaf);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class RequestRemovedNotifier implements zzc<OnRequestReceivedListener> {
        private final String zzOn;

        RequestRemovedNotifier(String str) {
            this.zzOn = str;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzOn);
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzvy() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<SendRequestResult> zzbag;

        public RequestSentBinderCallbacks(zzb<SendRequestResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_SendRequestResult) {
            this.zzbag = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzbag.setResult(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadRequestSummariesResult> zzbah;

        public RequestSummariesLoadedBinderCallbacks(zzb<LoadRequestSummariesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult) {
            this.zzbah = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzbah.setResult(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadRequestsResult> zzbai;

        public RequestsLoadedBinderCallbacks(zzb<LoadRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult) {
            this.zzbai = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzbai.setResult(new LoadRequestsResultImpl(GamesStatusCodes.zzib(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<UpdateRequestsResult> zzbaj;

        public RequestsUpdatedBinderCallbacks(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult) {
            this.zzbaj = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzbaj.setResult(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzaaz<? extends RoomUpdateListener> zzbak;
        private final zzaaz<? extends RoomStatusUpdateListener> zzbal;
        private final zzaaz<RealTimeMessageReceivedListener> zzbam;

        public RoomBinderCallbacks(zzaaz<RoomUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener) {
            this.zzbak = (zzaaz) zzac.zzb((Object) com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, (Object) "Callbacks must not be null");
            this.zzbal = null;
            this.zzbam = null;
        }

        public RoomBinderCallbacks(zzaaz<? extends RoomUpdateListener> com_google_android_gms_internal_zzaaz__extends_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzaaz<? extends RoomStatusUpdateListener> com_google_android_gms_internal_zzaaz__extends_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzaaz<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener) {
            this.zzbak = (zzaaz) zzac.zzb((Object) com_google_android_gms_internal_zzaaz__extends_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, (Object) "Callbacks must not be null");
            this.zzbal = com_google_android_gms_internal_zzaaz__extends_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener;
            this.zzbam = com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener;
        }

        public void onLeftRoom(int i, String str) {
            this.zzbak.zza(new LeftRoomNotifier(i, str));
        }

        public void onP2PConnected(String str) {
            if (this.zzbal != null) {
                this.zzbal.zza(new P2PConnectedNotifier(str));
            }
        }

        public void onP2PDisconnected(String str) {
            if (this.zzbal != null) {
                this.zzbal.zza(new P2PDisconnectedNotifier(str));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.zzbam != null) {
                this.zzbam.zza(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        public void zzA(DataHolder dataHolder) {
            this.zzbak.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzB(DataHolder dataHolder) {
            if (this.zzbal != null) {
                this.zzbal.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzbal != null) {
                this.zzbal.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            this.zzbak.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzE(DataHolder dataHolder) {
            if (this.zzbal != null) {
                this.zzbal.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzF(DataHolder dataHolder) {
            if (this.zzbal != null) {
                this.zzbal.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzbal != null) {
                this.zzbal.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzz(DataHolder dataHolder) {
            this.zzbak.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendFriendInviteFirstPartyBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InviteUpdateResult> zzaFq;

        SendFriendInviteFirstPartyBinderCallback(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, (Object) "Holder must not be null");
        }

        public void zzZ(DataHolder dataHolder) {
            this.zzaFq.setResult(new InviteUpdateResultImpl(dataHolder));
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzbaf;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzbaf = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzbaf = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SetPlayerMutedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayersResult> zzaFq;

        SetPlayerMutedBinderCallback(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, (Object) "Holder must not be null");
        }

        public void zzag(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        public SignOutCompleteBinderCallbacks(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzDW() {
            this.zzaFq.setResult(GamesStatusCodes.zzib(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CommitSnapshotResult> zzban;

        public SnapshotCommittedBinderCallbacks(zzb<CommitSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult) {
            this.zzban = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzban.setResult(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<DeleteSnapshotResult> zzaFq;

        public SnapshotDeletedBinderCallbacks(zzb<DeleteSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, (Object) "Holder must not be null");
        }

        public void zzk(int i, String str) {
            this.zzaFq.setResult(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<OpenSnapshotResult> zzbao;

        public SnapshotOpenedBinderCallbacks(zzb<OpenSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult) {
            this.zzbao = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc) {
            this.zzbao.setResult(new OpenSnapshotResultImpl(dataHolder, com_google_android_gms_drive_zzc));
        }

        public void zza(DataHolder dataHolder, String str, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc2, com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc3) {
            this.zzbao.setResult(new OpenSnapshotResultImpl(dataHolder, str, com_google_android_gms_drive_zzc, com_google_android_gms_drive_zzc2, com_google_android_gms_drive_zzc3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadSnapshotsResult> zzbap;

        public SnapshotsLoadedBinderCallbacks(zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult) {
            this.zzbap = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, (Object) "Holder must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzbap.setResult(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SocialInviteRemovedNotifier implements zzc<OnSocialInviteUpdateReceivedListener> {
        private final SocialInvite zzbaq;

        SocialInviteRemovedNotifier(SocialInvite socialInvite) {
            this.zzbaq = socialInvite;
        }

        public /* bridge */ /* synthetic */ void zzs(Object obj) {
        }

        public void zzvy() {
        }
    }

    private static final class SocialInviteUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        public void zzab(DataHolder dataHolder) {
            zzaaz com_google_android_gms_internal_zzaaz = null;
            SocialInviteBuffer socialInviteBuffer = new SocialInviteBuffer(dataHolder);
            try {
                SocialInvite socialInvite;
                if (socialInviteBuffer.getCount() > 0) {
                    socialInvite = (SocialInvite) ((SocialInvite) socialInviteBuffer.get(0)).freeze();
                } else {
                    Object obj = com_google_android_gms_internal_zzaaz;
                }
                socialInviteBuffer.release();
                if (socialInvite != null) {
                    com_google_android_gms_internal_zzaaz.zza(new SocialInviteUpdateReceivedNotifier(socialInvite));
                }
            } catch (Throwable th) {
                socialInviteBuffer.release();
            }
        }

        public void zzac(DataHolder dataHolder) {
            zzaaz com_google_android_gms_internal_zzaaz = null;
            SocialInviteBuffer socialInviteBuffer = new SocialInviteBuffer(dataHolder);
            try {
                SocialInvite socialInvite;
                if (socialInviteBuffer.getCount() > 0) {
                    socialInvite = (SocialInvite) ((SocialInvite) socialInviteBuffer.get(0)).freeze();
                } else {
                    Object obj = com_google_android_gms_internal_zzaaz;
                }
                socialInviteBuffer.release();
                if (socialInvite != null) {
                    com_google_android_gms_internal_zzaaz.zza(new SocialInviteRemovedNotifier(socialInvite));
                }
            } catch (Throwable th) {
                socialInviteBuffer.release();
            }
        }
    }

    private static final class SocialInviteUpdateReceivedNotifier implements zzc<OnSocialInviteUpdateReceivedListener> {
        private final SocialInvite zzbaq;

        SocialInviteUpdateReceivedNotifier(SocialInvite socialInvite) {
            this.zzbaq = socialInvite;
        }

        public /* bridge */ /* synthetic */ void zzs(Object obj) {
        }

        public void zzvy() {
        }
    }

    private static final class StockProfileImagesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadStockProfileImagesResult> zzaFq;

        StockProfileImagesLoadedBinderCallback(zzb<LoadStockProfileImagesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadStockProfileImagesResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadStockProfileImagesResult;
        }

        public void zzY(DataHolder dataHolder) {
            this.zzaFq.setResult(new LoadStockProfileImagesResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<SubmitScoreResult> zzaFq;

        public SubmitScoreBinderCallbacks(zzb<SubmitScoreResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzaFq.setResult(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzbar;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzbar = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzbar;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CancelMatchResult> zzbas;

        public TurnBasedMatchCanceledBinderCallbacks(zzb<CancelMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult) {
            this.zzbas = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, (Object) "Holder must not be null");
        }

        public void zzj(int i, String str) {
            this.zzbas.setResult(new CancelMatchResultImpl(GamesStatusCodes.zzib(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<InitiateMatchResult> zzbat;

        public TurnBasedMatchInitiatedBinderCallbacks(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult) {
            this.zzbat = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzbat.setResult(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LeaveMatchResult> zzbau;

        public TurnBasedMatchLeftBinderCallbacks(zzb<LeaveMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult) {
            this.zzbau = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, (Object) "Holder must not be null");
        }

        public void zzx(DataHolder dataHolder) {
            this.zzbau.setResult(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadMatchResult> zzbav;

        public TurnBasedMatchLoadedBinderCallbacks(zzb<LoadMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult) {
            this.zzbav = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzbav.setResult(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<UpdateMatchResult> zzbaw;

        public TurnBasedMatchUpdatedBinderCallbacks(zzb<UpdateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult) {
            this.zzbaw = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, (Object) "Holder must not be null");
        }

        public void zzw(DataHolder dataHolder) {
            this.zzbaw.setResult(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadMatchesResult> zzbax;

        public TurnBasedMatchesLoadedBinderCallbacks(zzb<LoadMatchesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult) {
            this.zzbax = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzbax.setResult(new LoadMatchesResultImpl(GamesStatusCodes.zzib(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final String zzaYb;
        private final Status zzahq;

        UpdateAchievementResultImpl(int i, String str) {
            this.zzahq = GamesStatusCodes.zzib(i);
            this.zzaYb = str;
        }

        public String getAchievementId() {
            return this.zzaYb;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class UpdateAutoSignInBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        UpdateAutoSignInBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzit(int i) {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class UpdateGamerProfileResultImpl implements UpdateGamerProfileResult {
        private final Status zzahq;
        private final Bundle zzbay;

        UpdateGamerProfileResultImpl(int i, Bundle bundle) {
            this.zzahq = new Status(i);
            this.zzbay = bundle;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class UpdateHeadlessCapturePermissionBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        UpdateHeadlessCapturePermissionBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = (zzb) zzac.zzb((Object) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzan(Status status) {
            this.zzaFq.setResult(status);
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateProfileDiscoverabilityBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzaFq;

        UpdateProfileDiscoverabilityBinderCallback(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zziu(int i) {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzbaz;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzbaz = RequestUpdateOutcomes.zzal(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzbaz.getRequestIds();
        }

        public int getRequestOutcome(String str) {
            return this.zzbaz.getRequestOutcome(str);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzaYP = new C07071(this);
        this.zzaYU = false;
        this.zzaYQ = com_google_android_gms_common_internal_zzg.zzxh();
        this.zzaYV = new Binder();
        this.zzaYT = PopupManager.zza(this, com_google_android_gms_common_internal_zzg.zzxd());
        this.zzaYW = (long) hashCode();
        this.zzaYX = gamesOptions;
        zzv(com_google_android_gms_common_internal_zzg.zzxj());
    }

    private void zzEa() {
        this.zzaYR = null;
        this.zzaYS = null;
    }

    private static Room zzai(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzd(RemoteException remoteException) {
        GamesLog.zzc("GamesClientImpl", "service died", remoteException);
    }

    public void disconnect() {
        this.zzaYU = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzwW();
                iGamesService.zzEy();
                this.zzaYP.flush();
                iGamesService.zzM(this.zzaYW);
            } catch (RemoteException e) {
                GamesLog.zzE("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzaYU = false;
    }

    public String zzEb() {
        try {
            return ((IGamesService) zzwW()).zzEb();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Player zzEc() {
        zzwV();
        synchronized (this) {
            if (this.zzaYR == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzwW()).zzEB());
                    if (playerBuffer.getCount() > 0) {
                        this.zzaYR = (PlayerEntity) ((Player) playerBuffer.get(0)).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzd(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzaYR;
    }

    public Game zzEd() {
        zzwV();
        synchronized (this) {
            if (this.zzaYS == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzwW()).zzED());
                    if (gameBuffer.getCount() > 0) {
                        this.zzaYS = (GameEntity) ((Game) gameBuffer.get(0)).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzd(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzaYS;
    }

    public Intent zzEe() {
        try {
            return ((IGamesService) zzwW()).zzEe();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzEf() {
        try {
            return ((IGamesService) zzwW()).zzEf();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzEg() {
        try {
            return ((IGamesService) zzwW()).zzEg();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzEh() {
        try {
            return ((IGamesService) zzwW()).zzEh();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzEi() {
        try {
            ((IGamesService) zzwW()).zzN(this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzEj() {
        try {
            ((IGamesService) zzwW()).zzO(this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzEk() {
        try {
            ((IGamesService) zzwW()).zzQ(this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzEl() {
        try {
            ((IGamesService) zzwW()).zzP(this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public Intent zzEm() {
        try {
            return ((IGamesService) zzwW()).zzEm();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzEn() {
        try {
            return ((IGamesService) zzwW()).zzEn();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public int zzEo() {
        try {
            return ((IGamesService) zzwW()).zzEo();
        } catch (RemoteException e) {
            zzd(e);
            return 4368;
        }
    }

    public int zzEp() {
        try {
            return ((IGamesService) zzwW()).zzEp();
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public Intent zzEq() {
        try {
            return ((IGamesService) zzwW()).zzEq();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public int zzEr() {
        try {
            return ((IGamesService) zzwW()).zzEr();
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public int zzEs() {
        try {
            return ((IGamesService) zzwW()).zzEs();
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public int zzEt() {
        try {
            return ((IGamesService) zzwW()).zzEt();
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public int zzEu() {
        try {
            return ((IGamesService) zzwW()).zzEu();
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public Intent zzEv() {
        try {
            return ((IGamesService) zzwW()).zzEJ();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public boolean zzEw() {
        try {
            return ((IGamesService) zzwW()).zzEw();
        } catch (RemoteException e) {
            zzd(e);
            return false;
        }
    }

    public void zzEx() {
        try {
            ((IGamesService) zzwW()).zzT(this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzEy() {
        if (isConnected()) {
            try {
                ((IGamesService) zzwW()).zzEy();
            } catch (RemoteException e) {
                zzd(e);
            }
        }
    }

    public int zza(zzaaz<ReliableMessageSentCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzwW()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzac.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzwW()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzwW()).zza(i, bArr, i2, str);
            zzac.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzwW()).zza(playerEntity);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzwW()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzwW()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaYU = bundle.getBoolean("show_welcome_popup");
            this.zzaYR = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaYS = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(Account account, byte[] bArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(account, bArr);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzwW()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzd(e);
            }
        }
    }

    public void zza(zzf com_google_android_gms_common_internal_zzf_zzf) {
        zzEa();
        super.zza(com_google_android_gms_common_internal_zzf_zzf);
    }

    public void zza(BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl, String str, VideoConfiguration videoConfiguration) throws RemoteException {
        ((IGamesService) zzwW()).zza(new CaptureLaunchGameAndOverlayBinderCallback(baseGamesApiMethodImpl), str, videoConfiguration);
    }

    public void zza(@NonNull IGamesService iGamesService) {
        super.zza((IInterface) iGamesService);
        if (this.zzaYU) {
            this.zzaYT.zzEN();
            this.zzaYU = false;
        }
        zzb(iGamesService);
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzac.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        com.google.android.gms.drive.zzc zzzB = snapshotContents.zzzB();
        snapshotContents.close();
        try {
            ((IGamesService) zzwW()).zza(zzzB);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zza(zzaaz<OnInvitationReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzwW()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zza(zzaaz<RoomUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzaaz<RoomStatusUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzaaz<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzwW()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaYV, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zza(zzaaz<RoomUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzwW()).zzc(new RoomBinderCallbacks(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zza(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zzwW()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zza(zzb<LoadRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zzb<LoadAppContentResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zzb<LoadMatchesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, Account account) throws RemoteException {
        ((IGamesService) zzwW()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), account);
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzwW()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzFA().asBundle(), i, i2);
    }

    public void zza(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzwW()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzFG(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zzb<CommitSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzac.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzFL = snapshotMetadataChange.zzFL();
        if (zzFL != null) {
            zzFL.zzd(getContext().getCacheDir());
        }
        com.google.android.gms.drive.zzc zzzB = snapshotContents.zzzB();
        snapshotContents.close();
        ((IGamesService) zzwW()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzzB);
    }

    public void zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, VideoConfiguration videoConfiguration, CaptureRuntimeErrorCallback captureRuntimeErrorCallback) throws RemoteException {
        ((IGamesService) zzwW()).zza(new CaptureStartedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, captureRuntimeErrorCallback), videoConfiguration);
    }

    public void zza(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzwW()).zza(iGamesCallbacks, str, this.zzaYT.zzEP(), this.zzaYT.zzEO());
    }

    public void zza(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zza(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaYT.zzEP(), this.zzaYT.zzEO());
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case MessageApi.FILTER_LITERAL /*0*/:
                ((IGamesService) zzwW()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
            default:
                String str2 = "Invalid player collection: ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public void zza(zzb<LoadMatchesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zzb<SubmitScoreResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzwW()).zza(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zzb<LeaveMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zzb<LoadPlayerScoreResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzwW()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zzb<LoadRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 3;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 2;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
            case 1919070037:
                if (str.equals("connected_1p")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                ((IGamesService) zzwW()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
            default:
                String str3 = "Invalid player collection: ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
    }

    public void zza(zzb<OpenSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzac.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzFL = snapshotMetadataChange.zzFL();
        if (zzFL != null) {
            zzFL.zzd(getContext().getCacheDir());
        }
        com.google.android.gms.drive.zzc zzzB = snapshotContents.zzzB();
        snapshotContents.close();
        ((IGamesService) zzwW()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzzB);
    }

    public void zza(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zzb<OpenSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzwW()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zzb<UpdateGamerProfileResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_UpdateGamerProfileResult, String str, boolean z, String str2, boolean z2, boolean z3) throws RemoteException {
        ((IGamesService) zzwW()).zza(new GamerProfileUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_UpdateGamerProfileResult), str, z, str2, z2, z3);
    }

    public void zza(zzb<UpdateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zzb<UpdateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zzb<SendRequestResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestSentBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zzb<LoadProfileSettingsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zza(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z, z2);
    }

    public void zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z, boolean z2, Bundle bundle) throws RemoteException {
        ((IGamesService) zzwW()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z, z2, bundle);
    }

    public void zza(zzb<LoadEventsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public String zzax(boolean z) {
        if (z && this.zzaYR != null) {
            return this.zzaYR.getPlayerId();
        }
        try {
            return ((IGamesService) zzwW()).zzEA();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzwW()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzb(IGamesService iGamesService) {
        try {
            iGamesService.zza(new PopupLocationInfoBinderCallbacks(this.zzaYT), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzb(zzaaz<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzwW()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzb(zzaaz<RoomUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzaaz<RoomStatusUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzaaz<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzwW()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzaaz_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaYV, roomConfig.getInvitationId(), false, this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzb(zzb<CaptureAvailableResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureAvailableResult, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new CaptureAvailableBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureAvailableResult), i);
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzwW()).zzb(iGamesCallbacks, str, this.zzaYT.zzEP(), this.zzaYT.zzEO());
    }

    public void zzb(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzb(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaYT.zzEP(), this.zzaYT.zzEO());
    }

    public void zzb(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zzb<ClaimMilestoneResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zzb<LoadScoresResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zzb<LoadAchievementsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zzb<LoadQuestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(String str, zzb<GetServerAuthCodeResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult) throws RemoteException {
        zzac.zzh(str, "Please provide a valid serverClientId");
        ((IGamesService) zzwW()).zza(str, new GetServerAuthCodeBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult));
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzwW()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public Intent zzc(int[] iArr) {
        try {
            return ((IGamesService) zzwW()).zzc(iArr);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    protected Set<Scope> zzc(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzac.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzac.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzc(zzaaz<QuestUpdateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzwW()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_quest_QuestUpdateListener), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzc(zzb<LoadInvitesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_LoadInvitesResult, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new InvitesLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_LoadInvitesResult), i);
    }

    public void zzc(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzk(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zzb<ListVideosResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzd(new ListVideosBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult), str, i);
    }

    public void zzc(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzwW()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzh(new UpdateHeadlessCapturePermissionBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), str, z);
    }

    public void zzc(zzb<LoadAchievementsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    protected IGamesService zzcP(IBinder iBinder) {
        return Stub.zzcS(iBinder);
    }

    public void zzd(zzaaz<OnRequestReceivedListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzwW()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzd(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zzb<LoadXpStreamResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zzb<InitiateMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzwW()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzd(zzb<LoadEventsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public int zze(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzwW()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzd(e);
            return -1;
        }
    }

    public void zze(zzaaz<CaptureOverlayStateListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_games_video_Videos_CaptureOverlayStateListener) {
        try {
            ((IGamesService) zzwW()).zzf(new CaptureOverlayStateBinderCallback(com_google_android_gms_internal_zzaaz_com_google_android_gms_games_video_Videos_CaptureOverlayStateListener), this.zzaYW);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zze(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzwW()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zze(zzb<LeaveMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzn(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zzb<LoadXpStreamResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zze(zzb<GameMuteStatusChangeResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zze(zzb<LoadPlayerStatsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzi(new PlayerStatsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult), z);
    }

    public void zzeq(String str) {
        try {
            ((IGamesService) zzwW()).zzey(str);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public Intent zzer(String str) {
        try {
            return ((IGamesService) zzwW()).zzer(str);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzes(String str) {
        try {
            ((IGamesService) zzwW()).zza(str, this.zzaYT.zzEP(), this.zzaYT.zzEO());
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    protected String zzeu() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzf(Account account) throws RemoteException {
        ((IGamesService) zzwW()).zzf(account);
    }

    public void zzf(zzb<GetTokenResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetTokenResult) throws RemoteException {
        ((IGamesService) zzwW()).zzj(new GetAuthTokenBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Games_GetTokenResult));
    }

    public void zzf(zzb<CancelMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzm(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zzf(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzg(new SetPlayerMutedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zzf(zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    public void zzg(zzb<LoadGamesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zzwW()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zzg(zzb<LoadMatchResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzo(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zzb<LoadRequestSummariesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zzwW()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzg(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzm(new CapturePausedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z);
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcP(iBinder);
    }

    public void zzh(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzh(zzb<AcceptQuestResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzaYP.flush();
        ((IGamesService) zzwW()).zzt(new QuestAcceptedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzi(zzb<CaptureCapabilitiesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureCapabilitiesResult) throws RemoteException {
        ((IGamesService) zzwW()).zzl(new CaptureCapabilitiesBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureCapabilitiesResult));
    }

    public void zzi(zzb<DeleteSnapshotResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzq(new SnapshotDeletedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzi(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzj(new DeletePlayerBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zziy(int i) {
        this.zzaYT.setGravity(i);
    }

    public void zziz(int i) {
        try {
            ((IGamesService) zzwW()).zziz(i);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzj(zzb<CaptureStateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStateResult) throws RemoteException {
        ((IGamesService) zzwW()).zzv(new CaptureStateBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStateResult));
    }

    public void zzj(zzb<LoadGameInstancesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzj(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzk(new UpdateAutoSignInBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z);
    }

    public String zzjI() {
        try {
            return ((IGamesService) zzwW()).zzjI();
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzk(zzb<CaptureStreamingAvailabilityResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingAvailabilityResult) throws RemoteException {
        ((IGamesService) zzwW()).zzs(new CaptureStreamingAvailabilityBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingAvailabilityResult));
    }

    public void zzk(zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzp(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public void zzk(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zzl(new UpdateProfileDiscoverabilityBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), z);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzwW()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzl(zzb<CaptureStreamingMetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingMetadataResult) throws RemoteException {
        ((IGamesService) zzwW()).zzq(new CaptureStreamingMetadataBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingMetadataResult));
    }

    public void zzl(zzb<LoadXpForGameCategoriesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzr(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    public void zzl(zzb<ContactSettingLoadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zzwW()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzm(zzb<CaptureStreamingUrlResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingUrlResult) throws RemoteException {
        ((IGamesService) zzwW()).zzr(new CaptureStreamingUrlBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStreamingUrlResult));
    }

    public void zzm(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzj(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public void zzn(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((IGamesService) zzwW()).zzt(new HeadlessCaptureEnabledBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzn(zzb<GameMuteStatusLoadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzo(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((IGamesService) zzwW()).zzo(new CaptureStreamingEnabledBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzo(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzu(new SendFriendInviteFirstPartyBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult), str);
    }

    public void zzo(String str, int i) {
        this.zzaYP.zzo(str, i);
    }

    public void zzp(zzb<ListVideosResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult) throws RemoteException {
        ((IGamesService) zzwW()).zzk(new ListVideosBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_ListVideosResult));
    }

    public void zzp(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzv(new AcceptFriendInviteFirstPartyBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult), str);
    }

    public void zzp(String str, int i) {
        try {
            ((IGamesService) zzwW()).zzp(str, i);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public void zzq(zzb<CaptureStoppedResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStoppedResult) throws RemoteException {
        ((IGamesService) zzwW()).zzu(new CaptureStoppedBinderCallbacks(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_video_Videos_CaptureStoppedResult));
    }

    public void zzq(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzw(new IgnoreFriendInviteFirstPartyBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult), str);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzwW()).zzq(str, i);
        } catch (RemoteException e) {
            zzd(e);
        }
    }

    public boolean zzqD() {
        return true;
    }

    protected Bundle zzql() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzDb = this.zzaYX.zzDb();
        zzDb.putString("com.google.android.gms.games.key.gamePackageName", this.zzaYQ);
        zzDb.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzDb.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaYT.zzEP()));
        zzDb.putInt("com.google.android.gms.games.key.API_VERSION", 4);
        zzDb.putBundle("com.google.android.gms.games.key.signInOptions", zzaxy.zza(zzxp()));
        return zzDb;
    }

    public void zzr(zzb<LoadStockProfileImagesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadStockProfileImagesResult) throws RemoteException {
        ((IGamesService) zzwW()).zzp(new StockProfileImagesLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadStockProfileImagesResult));
    }

    public void zzr(zzb<InviteUpdateResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzx(new CancelFriendInviteFirstPartyBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_social_Social_InviteUpdateResult), str);
    }

    public void zzs(zzb<InboxCountResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zzwW()).zzs(new InboxCountsLoadedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzs(zzb<LoadPlayersResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str) throws RemoteException {
        ((IGamesService) zzwW()).zzy(new PlayerUnfriendedBinderCallback(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str);
    }

    public Bundle zzud() {
        try {
            Bundle zzud = ((IGamesService) zzwW()).zzud();
            if (zzud == null) {
                return zzud;
            }
            zzud.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzud;
        } catch (RemoteException e) {
            zzd(e);
            return null;
        }
    }

    public void zzv(View view) {
        this.zzaYT.zzw(view);
    }
}

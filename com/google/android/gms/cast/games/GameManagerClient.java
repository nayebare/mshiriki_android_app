package com.google.android.gms.cast.games;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzxz;
import org.json.JSONObject;

public final class GameManagerClient {
    public static final int GAMEPLAY_STATE_LOADING = 1;
    public static final int GAMEPLAY_STATE_PAUSED = 3;
    public static final int GAMEPLAY_STATE_RUNNING = 2;
    public static final int GAMEPLAY_STATE_SHOWING_INFO_SCREEN = 4;
    public static final int GAMEPLAY_STATE_UNKNOWN = 0;
    public static final int LOBBY_STATE_CLOSED = 2;
    public static final int LOBBY_STATE_OPEN = 1;
    public static final int LOBBY_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_AVAILABLE = 3;
    public static final int PLAYER_STATE_DROPPED = 1;
    public static final int PLAYER_STATE_IDLE = 5;
    public static final int PLAYER_STATE_PLAYING = 6;
    public static final int PLAYER_STATE_QUIT = 2;
    public static final int PLAYER_STATE_READY = 4;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int STATUS_INCORRECT_VERSION = 2150;
    public static final int STATUS_TOO_MANY_PLAYERS = 2151;
    private final zzxz zzatV;

    public interface GameManagerInstanceResult extends Result {
        GameManagerClient getGameManagerClient();
    }

    public interface GameManagerResult extends Result {
        JSONObject getExtraMessageData();

        String getPlayerId();

        long getRequestId();
    }

    public interface Listener {
        void onGameMessageReceived(String str, JSONObject jSONObject);

        void onStateChanged(GameManagerState gameManagerState, GameManagerState gameManagerState2);
    }

    public GameManagerClient(zzxz com_google_android_gms_internal_zzxz) {
        this.zzatV = com_google_android_gms_internal_zzxz;
    }

    public static PendingResult<GameManagerInstanceResult> getInstanceFor(GoogleApiClient googleApiClient, String str) throws IllegalArgumentException {
        return zza(new zzxz(googleApiClient, str, Cast.CastApi));
    }

    static PendingResult<GameManagerInstanceResult> zza(zzxz com_google_android_gms_internal_zzxz) throws IllegalArgumentException {
        return com_google_android_gms_internal_zzxz.zza(new GameManagerClient(com_google_android_gms_internal_zzxz));
    }

    private PendingResult<GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        return this.zzatV.zza(str, i, jSONObject);
    }

    public void dispose() {
        this.zzatV.dispose();
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        return this.zzatV.getCurrentState();
    }

    public String getLastUsedPlayerId() throws IllegalStateException {
        return this.zzatV.getLastUsedPlayerId();
    }

    public boolean isDisposed() {
        return this.zzatV.isDisposed();
    }

    public void sendGameMessage(String str, JSONObject jSONObject) throws IllegalStateException {
        this.zzatV.sendGameMessage(str, jSONObject);
    }

    public void sendGameMessage(JSONObject jSONObject) throws IllegalStateException {
        sendGameMessage(getLastUsedPlayerId(), jSONObject);
    }

    public PendingResult<GameManagerResult> sendGameRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return this.zzatV.sendGameRequest(str, jSONObject);
    }

    public PendingResult<GameManagerResult> sendGameRequest(JSONObject jSONObject) throws IllegalStateException {
        return sendGameRequest(getLastUsedPlayerId(), jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return zza(str, PLAYER_STATE_AVAILABLE, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(JSONObject jSONObject) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_AVAILABLE, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return zza(str, PLAYER_STATE_IDLE, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(JSONObject jSONObject) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_IDLE, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return zza(str, PLAYER_STATE_PLAYING, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(JSONObject jSONObject) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_PLAYING, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return zza(str, PLAYER_STATE_QUIT, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(JSONObject jSONObject) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_QUIT, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        return zza(str, PLAYER_STATE_READY, jSONObject);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(JSONObject jSONObject) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_READY, jSONObject);
    }

    public void setListener(Listener listener) {
        this.zzatV.setListener(listener);
    }

    public void setSessionLabel(String str) {
        this.zzatV.setSessionLabel(str);
    }
}

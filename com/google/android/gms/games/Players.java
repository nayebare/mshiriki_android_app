package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.internal.player.StockProfileImage;

public interface Players {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    public interface LoadPlayersResult extends Releasable, Result {
        PlayerBuffer getPlayers();
    }

    public interface LoadProfileSettingsResult extends Result {
        String zzDc();

        boolean zzDf();

        boolean zzDk();

        StockProfileImage zzDl();

        boolean zzDm();

        boolean zzDn();

        boolean zzDo();
    }

    public interface LoadStockProfileImagesResult extends Releasable, Result {
    }

    public interface LoadXpForGameCategoriesResult extends Result {
    }

    public interface LoadXpForGamesResult extends Result {
    }

    public interface LoadXpStreamResult extends Result {
    }

    public interface UpdateGamerProfileResult extends Result {
    }

    Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player);

    Player getCurrentPlayer(GoogleApiClient googleApiClient);

    String getCurrentPlayerId(GoogleApiClient googleApiClient);

    Intent getPlayerSearchIntent(GoogleApiClient googleApiClient);

    PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z);

    PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z);

    PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i);

    PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i);

    PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str);

    PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z);

    PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z);
}

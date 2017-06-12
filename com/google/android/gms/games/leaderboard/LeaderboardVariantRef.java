package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class LeaderboardVariantRef extends zzc implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFF();
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return zzdl("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return zzdl("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return zzdl("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !zzdl("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.zza(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.zzb(this);
    }

    public String zzFC() {
        return getString("top_page_token_next");
    }

    public String zzFD() {
        return getString("window_page_token_prev");
    }

    public String zzFE() {
        return getString("window_page_token_next");
    }

    public LeaderboardVariant zzFF() {
        return new LeaderboardVariantEntity(this);
    }
}

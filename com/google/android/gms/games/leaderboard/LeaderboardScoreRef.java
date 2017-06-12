package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzbdm;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzbdm = new PlayerRef(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFB();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zza("display_rank", charArrayBuffer);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zza("display_score", charArrayBuffer);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzdl("external_player_id") ? null : this.zzbdm;
    }

    public String getScoreHolderDisplayName() {
        return zzdl("external_player_id") ? getString("default_display_name") : this.zzbdm.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (zzdl("external_player_id")) {
            zza("default_display_name", charArrayBuffer);
        } else {
            this.zzbdm.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzdl("external_player_id") ? null : this.zzbdm.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzdl("external_player_id") ? null : this.zzbdm.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzdl("external_player_id") ? zzdk("default_display_image_uri") : this.zzbdm.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzdl("external_player_id") ? getString("default_display_image_url") : this.zzbdm.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzFB() {
        return new LeaderboardScoreEntity(this);
    }
}

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zzbda;
    private final String zzbdb;
    private final String zzbdc;
    private final long zzbdd;
    private final long zzbde;
    private final String zzbdf;
    private final Uri zzbdg;
    private final Uri zzbdh;
    private final PlayerEntity zzbdi;
    private final String zzbdj;
    private final String zzbdk;
    private final String zzbdl;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.zzbda = leaderboardScore.getRank();
        this.zzbdb = (String) zzac.zzw(leaderboardScore.getDisplayRank());
        this.zzbdc = (String) zzac.zzw(leaderboardScore.getDisplayScore());
        this.zzbdd = leaderboardScore.getRawScore();
        this.zzbde = leaderboardScore.getTimestampMillis();
        this.zzbdf = leaderboardScore.getScoreHolderDisplayName();
        this.zzbdg = leaderboardScore.getScoreHolderIconImageUri();
        this.zzbdh = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzbdi = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzbdj = leaderboardScore.getScoreTag();
        this.zzbdk = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzbdl = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzaa.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzaa.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzaa.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzaa.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzaa.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzaa.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzaa.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzaa.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzaa.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzaa.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzaa.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzaa.zzv(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFB();
    }

    public String getDisplayRank() {
        return this.zzbdb;
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzbdb, charArrayBuffer);
    }

    public String getDisplayScore() {
        return this.zzbdc;
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzbdc, charArrayBuffer);
    }

    public long getRank() {
        return this.zzbda;
    }

    public long getRawScore() {
        return this.zzbdd;
    }

    public Player getScoreHolder() {
        return this.zzbdi;
    }

    public String getScoreHolderDisplayName() {
        return this.zzbdi == null ? this.zzbdf : this.zzbdi.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzbdi == null) {
            zzg.zzb(this.zzbdf, charArrayBuffer);
        } else {
            this.zzbdi.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzbdi == null ? this.zzbdh : this.zzbdi.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzbdi == null ? this.zzbdl : this.zzbdi.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzbdi == null ? this.zzbdg : this.zzbdi.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzbdi == null ? this.zzbdk : this.zzbdi.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzbdj;
    }

    public long getTimestampMillis() {
        return this.zzbde;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public LeaderboardScore zzFB() {
        return this;
    }
}

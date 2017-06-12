package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzbdn;
    private final int zzbdo;
    private final boolean zzbdp;
    private final long zzbdq;
    private final String zzbdr;
    private final long zzbds;
    private final String zzbdt;
    private final String zzbdu;
    private final long zzbdv;
    private final String zzbdw;
    private final String zzbdx;
    private final String zzbdy;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zzbdn = leaderboardVariant.getTimeSpan();
        this.zzbdo = leaderboardVariant.getCollection();
        this.zzbdp = leaderboardVariant.hasPlayerInfo();
        this.zzbdq = leaderboardVariant.getRawPlayerScore();
        this.zzbdr = leaderboardVariant.getDisplayPlayerScore();
        this.zzbds = leaderboardVariant.getPlayerRank();
        this.zzbdt = leaderboardVariant.getDisplayPlayerRank();
        this.zzbdu = leaderboardVariant.getPlayerScoreTag();
        this.zzbdv = leaderboardVariant.getNumScores();
        this.zzbdw = leaderboardVariant.zzFC();
        this.zzbdx = leaderboardVariant.zzFD();
        this.zzbdy = leaderboardVariant.zzFE();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzaa.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzFC(), leaderboardVariant.zzFE(), leaderboardVariant.zzFD());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzaa.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzaa.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzaa.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzaa.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzaa.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzaa.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzaa.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzaa.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzaa.equal(leaderboardVariant2.zzFC(), leaderboardVariant.zzFC()) && zzaa.equal(leaderboardVariant2.zzFE(), leaderboardVariant.zzFE()) && zzaa.equal(leaderboardVariant2.zzFD(), leaderboardVariant.zzFD());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzaa.zzv(leaderboardVariant).zzg("TimeSpan", TimeSpan.zziC(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zziC(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzFC()).zzg("WindowPageNextToken", leaderboardVariant.zzFE()).zzg("WindowPagePrevToken", leaderboardVariant.zzFD()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFF();
    }

    public int getCollection() {
        return this.zzbdo;
    }

    public String getDisplayPlayerRank() {
        return this.zzbdt;
    }

    public String getDisplayPlayerScore() {
        return this.zzbdr;
    }

    public long getNumScores() {
        return this.zzbdv;
    }

    public long getPlayerRank() {
        return this.zzbds;
    }

    public String getPlayerScoreTag() {
        return this.zzbdu;
    }

    public long getRawPlayerScore() {
        return this.zzbdq;
    }

    public int getTimeSpan() {
        return this.zzbdn;
    }

    public boolean hasPlayerInfo() {
        return this.zzbdp;
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

    public String zzFC() {
        return this.zzbdw;
    }

    public String zzFD() {
        return this.zzbdx;
    }

    public String zzFE() {
        return this.zzbdy;
    }

    public LeaderboardVariant zzFF() {
        return this;
    }
}

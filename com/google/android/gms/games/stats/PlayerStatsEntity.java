package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public class PlayerStatsEntity extends GamesAbstractSafeParcelable implements PlayerStats {
    public static final Creator<PlayerStatsEntity> CREATOR;
    private final int mVersionCode;
    private final float zzbfa;
    private final float zzbfb;
    private final int zzbfc;
    private final int zzbfd;
    private final int zzbfe;
    private final float zzbff;
    private final float zzbfg;
    private final Bundle zzbfh;
    private final float zzbfi;
    private final float zzbfj;
    private final float zzbfk;

    static {
        CREATOR = new PlayerStatsEntityCreator();
    }

    PlayerStatsEntity(int i, float f, float f2, int i2, int i3, int i4, float f3, float f4, Bundle bundle, float f5, float f6, float f7) {
        this.mVersionCode = i;
        this.zzbfa = f;
        this.zzbfb = f2;
        this.zzbfc = i2;
        this.zzbfd = i3;
        this.zzbfe = i4;
        this.zzbff = f3;
        this.zzbfg = f4;
        this.zzbfh = bundle;
        this.zzbfi = f5;
        this.zzbfj = f6;
        this.zzbfk = f7;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.mVersionCode = 4;
        this.zzbfa = playerStats.getAverageSessionLength();
        this.zzbfb = playerStats.getChurnProbability();
        this.zzbfc = playerStats.getDaysSinceLastPlayed();
        this.zzbfd = playerStats.getNumberOfPurchases();
        this.zzbfe = playerStats.getNumberOfSessions();
        this.zzbff = playerStats.getSessionPercentile();
        this.zzbfg = playerStats.getSpendPercentile();
        this.zzbfi = playerStats.getSpendProbability();
        this.zzbfj = playerStats.getHighSpenderProbability();
        this.zzbfk = playerStats.getTotalSpendNext28Days();
        this.zzbfh = playerStats.zzFO();
    }

    static int zza(PlayerStats playerStats) {
        return zzaa.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzaa.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && zzaa.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && zzaa.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && zzaa.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && zzaa.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && zzaa.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && zzaa.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && zzaa.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && zzaa.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && zzaa.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    static String zzb(PlayerStats playerStats) {
        return zzaa.zzv(playerStats).zzg("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).zzg("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).zzg("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability())).zzg("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFP();
    }

    public float getAverageSessionLength() {
        return this.zzbfa;
    }

    public float getChurnProbability() {
        return this.zzbfb;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzbfc;
    }

    public float getHighSpenderProbability() {
        return this.zzbfj;
    }

    public int getNumberOfPurchases() {
        return this.zzbfd;
    }

    public int getNumberOfSessions() {
        return this.zzbfe;
    }

    public float getSessionPercentile() {
        return this.zzbff;
    }

    public float getSpendPercentile() {
        return this.zzbfg;
    }

    public float getSpendProbability() {
        return this.zzbfi;
    }

    public float getTotalSpendNext28Days() {
        return this.zzbfk;
    }

    public int getVersionCode() {
        return this.mVersionCode;
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

    public void writeToParcel(Parcel parcel, int i) {
        PlayerStatsEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzFO() {
        return this.zzbfh;
    }

    public PlayerStats zzFP() {
        return this;
    }
}

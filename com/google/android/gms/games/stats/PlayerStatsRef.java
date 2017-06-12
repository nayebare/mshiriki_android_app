package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public class PlayerStatsRef extends zzc implements PlayerStats {
    private Bundle zzbfh;

    PlayerStatsRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFP();
    }

    public float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    public float getChurnProbability() {
        return getFloat("churn_probability");
    }

    public int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    public float getHighSpenderProbability() {
        return !zzdj("high_spender_probability") ? PlayerStats.UNSET_VALUE : getFloat("high_spender_probability");
    }

    public int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    public int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    public float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    public float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    public float getSpendProbability() {
        return !zzdj("spend_probability") ? PlayerStats.UNSET_VALUE : getFloat("spend_probability");
    }

    public float getTotalSpendNext28Days() {
        return !zzdj("total_spend_next_28_days") ? PlayerStats.UNSET_VALUE : getFloat("total_spend_next_28_days");
    }

    public int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerStatsEntity) ((PlayerStats) freeze())).writeToParcel(parcel, i);
    }

    public Bundle zzFO() {
        int i = 0;
        if (this.zzbfh != null) {
            return this.zzbfh;
        }
        this.zzbfh = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (!(string == null || string2 == null)) {
            String[] split = string.split(",");
            String[] split2 = string2.split(",");
            com.google.android.gms.common.internal.zzc.zza(split.length <= split2.length, "Invalid raw arguments!");
            while (i < split.length) {
                this.zzbfh.putString(split[i], split2[i]);
                i++;
            }
        }
        return this.zzbfh;
    }

    public PlayerStats zzFP() {
        return new PlayerStatsEntity(this);
    }
}

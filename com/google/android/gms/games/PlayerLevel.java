package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class PlayerLevel extends GamesAbstractSafeParcelable {
    public static final Creator<PlayerLevel> CREATOR;
    private final int mVersionCode;
    private final int zzaXS;
    private final long zzaXT;
    private final long zzaXU;

    static {
        CREATOR = new PlayerLevelCreator();
    }

    PlayerLevel(int i, int i2, long j, long j2) {
        boolean z = true;
        zzac.zza(j >= 0, (Object) "Min XP must be positive!");
        if (j2 <= j) {
            z = false;
        }
        zzac.zza(z, (Object) "Max XP must be more than min XP!");
        this.mVersionCode = i;
        this.zzaXS = i2;
        this.zzaXT = j;
        this.zzaXU = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzaa.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzaa.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzaa.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zzaXS;
    }

    public long getMaxXp() {
        return this.zzaXU;
    }

    public long getMinXp() {
        return this.zzaXT;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaXS), Long.valueOf(this.zzaXT), Long.valueOf(this.zzaXU));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.zza(this, parcel, i);
    }
}

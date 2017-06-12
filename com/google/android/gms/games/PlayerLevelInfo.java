package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final Creator<PlayerLevelInfo> CREATOR;
    private final int mVersionCode;
    private final long zzaXV;
    private final long zzaXW;
    private final PlayerLevel zzaXX;
    private final PlayerLevel zzaXY;

    static {
        CREATOR = new PlayerLevelInfoCreator();
    }

    PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzac.zzar(j != -1);
        zzac.zzw(playerLevel);
        zzac.zzw(playerLevel2);
        this.mVersionCode = i;
        this.zzaXV = j;
        this.zzaXW = j2;
        this.zzaXX = playerLevel;
        this.zzaXY = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzaa.equal(Long.valueOf(this.zzaXV), Long.valueOf(playerLevelInfo.zzaXV)) && zzaa.equal(Long.valueOf(this.zzaXW), Long.valueOf(playerLevelInfo.zzaXW)) && zzaa.equal(this.zzaXX, playerLevelInfo.zzaXX) && zzaa.equal(this.zzaXY, playerLevelInfo.zzaXY);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzaXX;
    }

    public long getCurrentXpTotal() {
        return this.zzaXV;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzaXW;
    }

    public PlayerLevel getNextLevel() {
        return this.zzaXY;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaXV), Long.valueOf(this.zzaXW), this.zzaXX, this.zzaXY);
    }

    public boolean isMaxLevel() {
        return this.zzaXX.equals(this.zzaXY);
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.zza(this, parcel, i);
    }
}

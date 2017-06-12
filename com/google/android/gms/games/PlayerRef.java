package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzaXI;
    private final PlayerColumnNames zzaXZ;
    private final MostRecentGameInfoRef zzaYa;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.zzaXZ = new PlayerColumnNames(str);
        this.zzaYa = new MostRecentGameInfoRef(dataHolder, i, this.zzaXZ);
        if (zzDj()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzaXZ.zzbcp);
            int integer2 = getInteger(this.zzaXZ.zzbcs);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzaXZ.zzbcq), getLong(this.zzaXZ.zzbcr));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzaXZ.zzbcr), getLong(this.zzaXZ.zzbct));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzaXI = new PlayerLevelInfo(getLong(this.zzaXZ.zzbco), getLong(this.zzaXZ.zzbcu), playerLevel2, playerLevel);
            return;
        }
        this.zzaXI = null;
    }

    private boolean zzDj() {
        return (zzdl(this.zzaXZ.zzbco) || getLong(this.zzaXZ.zzbco) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public Uri getBannerImageLandscapeUri() {
        return zzdk(this.zzaXZ.zzbcF);
    }

    public String getBannerImageLandscapeUrl() {
        return getString(this.zzaXZ.zzbcG);
    }

    public Uri getBannerImagePortraitUri() {
        return zzdk(this.zzaXZ.zzbcH);
    }

    public String getBannerImagePortraitUrl() {
        return getString(this.zzaXZ.zzbcI);
    }

    public String getDisplayName() {
        return getString(this.zzaXZ.zzbcg);
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zza(this.zzaXZ.zzbcg, charArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return zzdk(this.zzaXZ.zzbcj);
    }

    public String getHiResImageUrl() {
        return getString(this.zzaXZ.zzbck);
    }

    public Uri getIconImageUri() {
        return zzdk(this.zzaXZ.zzbch);
    }

    public String getIconImageUrl() {
        return getString(this.zzaXZ.zzbci);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzdj(this.zzaXZ.zzbcn) || zzdl(this.zzaXZ.zzbcn)) ? -1 : getLong(this.zzaXZ.zzbcn);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaXI;
    }

    public String getName() {
        return getString(this.zzaXZ.name);
    }

    public String getPlayerId() {
        return getString(this.zzaXZ.zzbcf);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzaXZ.zzbcl);
    }

    public String getTitle() {
        return getString(this.zzaXZ.title);
    }

    public void getTitle(CharArrayBuffer charArrayBuffer) {
        zza(this.zzaXZ.title, charArrayBuffer);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zza(this);
    }

    public boolean isMuted() {
        return getBoolean(this.zzaXZ.zzbcL);
    }

    public String toString() {
        return PlayerEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) ((Player) freeze())).writeToParcel(parcel, i);
    }

    public String zzDc() {
        return getString(this.zzaXZ.zzbcE);
    }

    public boolean zzDd() {
        return getBoolean(this.zzaXZ.zzbcD);
    }

    public int zzDe() {
        return getInteger(this.zzaXZ.zzbcm);
    }

    public boolean zzDf() {
        return getBoolean(this.zzaXZ.zzbcw);
    }

    public MostRecentGameInfo zzDg() {
        return zzdl(this.zzaXZ.zzbcx) ? null : this.zzaYa;
    }

    public int zzDh() {
        return getInteger(this.zzaXZ.zzbcJ);
    }

    public long zzDi() {
        return getLong(this.zzaXZ.zzbcK);
    }
}

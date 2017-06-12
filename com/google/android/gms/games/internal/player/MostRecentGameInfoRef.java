package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzaXZ;

    public MostRecentGameInfoRef(DataHolder dataHolder, int i, PlayerColumnNames playerColumnNames) {
        super(dataHolder, i);
        this.zzaXZ = playerColumnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFu();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((MostRecentGameInfo) freeze())).writeToParcel(parcel, i);
    }

    public String zzFo() {
        return getString(this.zzaXZ.zzbcx);
    }

    public String zzFp() {
        return getString(this.zzaXZ.zzbcy);
    }

    public long zzFq() {
        return getLong(this.zzaXZ.zzbcz);
    }

    public Uri zzFr() {
        return zzdk(this.zzaXZ.zzbcA);
    }

    public Uri zzFs() {
        return zzdk(this.zzaXZ.zzbcB);
    }

    public Uri zzFt() {
        return zzdk(this.zzaXZ.zzbcC);
    }

    public MostRecentGameInfo zzFu() {
        return new MostRecentGameInfoEntity(this);
    }
}

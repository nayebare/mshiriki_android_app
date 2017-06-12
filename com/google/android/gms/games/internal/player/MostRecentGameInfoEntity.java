package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class MostRecentGameInfoEntity extends GamesAbstractSafeParcelable implements MostRecentGameInfo {
    public static final Creator<MostRecentGameInfoEntity> CREATOR;
    private final int mVersionCode;
    private final String zzbbZ;
    private final String zzbca;
    private final long zzbcb;
    private final Uri zzbcc;
    private final Uri zzbcd;
    private final Uri zzbce;

    static {
        CREATOR = new MostRecentGameInfoEntityCreator();
    }

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.mVersionCode = i;
        this.zzbbZ = str;
        this.zzbca = str2;
        this.zzbcb = j;
        this.zzbcc = uri;
        this.zzbcd = uri2;
        this.zzbce = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.mVersionCode = 2;
        this.zzbbZ = mostRecentGameInfo.zzFo();
        this.zzbca = mostRecentGameInfo.zzFp();
        this.zzbcb = mostRecentGameInfo.zzFq();
        this.zzbcc = mostRecentGameInfo.zzFr();
        this.zzbcd = mostRecentGameInfo.zzFs();
        this.zzbce = mostRecentGameInfo.zzFt();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzaa.hashCode(mostRecentGameInfo.zzFo(), mostRecentGameInfo.zzFp(), Long.valueOf(mostRecentGameInfo.zzFq()), mostRecentGameInfo.zzFr(), mostRecentGameInfo.zzFs(), mostRecentGameInfo.zzFt());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzaa.equal(mostRecentGameInfo2.zzFo(), mostRecentGameInfo.zzFo()) && zzaa.equal(mostRecentGameInfo2.zzFp(), mostRecentGameInfo.zzFp()) && zzaa.equal(Long.valueOf(mostRecentGameInfo2.zzFq()), Long.valueOf(mostRecentGameInfo.zzFq())) && zzaa.equal(mostRecentGameInfo2.zzFr(), mostRecentGameInfo.zzFr()) && zzaa.equal(mostRecentGameInfo2.zzFs(), mostRecentGameInfo.zzFs()) && zzaa.equal(mostRecentGameInfo2.zzFt(), mostRecentGameInfo.zzFt());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzaa.zzv(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzFo()).zzg("GameName", mostRecentGameInfo.zzFp()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzFq())).zzg("GameIconUri", mostRecentGameInfo.zzFr()).zzg("GameHiResUri", mostRecentGameInfo.zzFs()).zzg("GameFeaturedUri", mostRecentGameInfo.zzFt()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFu();
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
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    public String zzFo() {
        return this.zzbbZ;
    }

    public String zzFp() {
        return this.zzbca;
    }

    public long zzFq() {
        return this.zzbcb;
    }

    public Uri zzFr() {
        return this.zzbcc;
    }

    public Uri zzFs() {
        return this.zzbcd;
    }

    public Uri zzFt() {
        return this.zzbce;
    }

    public MostRecentGameInfo zzFu() {
        return this;
    }
}

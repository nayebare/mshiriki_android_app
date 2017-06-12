package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class StockProfileImageEntity extends GamesAbstractSafeParcelable implements StockProfileImage {
    public static final Creator<StockProfileImageEntity> CREATOR;
    private final int mVersionCode;
    private final Uri zzaYq;
    private final String zzbcR;

    static {
        CREATOR = new StockProfileImageEntityCreator();
    }

    StockProfileImageEntity(int i, String str, Uri uri) {
        this.mVersionCode = i;
        this.zzbcR = str;
        this.zzaYq = uri;
    }

    public StockProfileImageEntity(StockProfileImage stockProfileImage) {
        this(1, stockProfileImage.getImageUrl(), stockProfileImage.zzDA());
    }

    public StockProfileImageEntity(String str, Uri uri) {
        this(1, str, uri);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return zzaa.equal(this.zzbcR, stockProfileImage.getImageUrl()) && zzaa.equal(this.zzaYq, stockProfileImage.zzDA());
    }

    public /* synthetic */ Object freeze() {
        return zzFv();
    }

    public String getImageUrl() {
        return this.zzbcR;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbcR, this.zzaYq);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("ImageId", this.zzbcR).zzg("ImageUri", this.zzaYq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        StockProfileImageEntityCreator.zza(this, parcel, i);
    }

    public Uri zzDA() {
        return this.zzaYq;
    }

    public StockProfileImage zzFv() {
        return this;
    }
}

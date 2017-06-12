package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final Creator<GameBadgeEntity> CREATOR;
    private final int mVersionCode;
    private Uri zzaWW;
    private String zzacd;
    private String zzalD;
    private int zzanR;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfG(parcel);
        }

        public GameBadgeEntity zzfG(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzfG(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    static {
        CREATOR = new GameBadgeEntityCreatorCompat();
    }

    GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.mVersionCode = i;
        this.zzanR = i2;
        this.zzalD = str;
        this.zzacd = str2;
        this.zzaWW = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.mVersionCode = 1;
        this.zzanR = gameBadge.getType();
        this.zzalD = gameBadge.getTitle();
        this.zzacd = gameBadge.getDescription();
        this.zzaWW = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzaa.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzaa.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzaa.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzaa.zzv(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFa();
    }

    public String getDescription() {
        return this.zzacd;
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getTitle() {
        return this.zzalD;
    }

    public int getType() {
        return this.zzanR;
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
        GameBadgeEntityCreator.zza(this, parcel, i);
    }

    public GameBadge zzFa() {
        return this;
    }
}

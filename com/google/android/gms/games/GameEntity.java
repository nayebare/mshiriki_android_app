package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR;
    private final int mVersionCode;
    private final boolean zzOD;
    private final String zzaWT;
    private final String zzaWU;
    private final String zzaWV;
    private final Uri zzaWW;
    private final Uri zzaWX;
    private final Uri zzaWY;
    private final boolean zzaWZ;
    private final boolean zzaXa;
    private final String zzaXb;
    private final int zzaXc;
    private final int zzaXd;
    private final int zzaXe;
    private final boolean zzaXf;
    private final boolean zzaXg;
    private final String zzaXh;
    private final String zzaXi;
    private final String zzaXj;
    private final boolean zzaXk;
    private final boolean zzaXl;
    private final String zzaXm;
    private final boolean zzaXn;
    private final String zzacd;
    private final String zzaiX;
    private final String zzalR;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfr(parcel);
        }

        public GameEntity zzfr(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(GameEntity.class.getCanonicalName())) {
                return super.zzfr(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    static {
        CREATOR = new GameEntityCreatorCompat();
    }

    GameEntity(int i, String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11, boolean z8) {
        this.mVersionCode = i;
        this.zzalR = str;
        this.zzaiX = str2;
        this.zzaWT = str3;
        this.zzaWU = str4;
        this.zzacd = str5;
        this.zzaWV = str6;
        this.zzaWW = uri;
        this.zzaXh = str8;
        this.zzaWX = uri2;
        this.zzaXi = str9;
        this.zzaWY = uri3;
        this.zzaXj = str10;
        this.zzaWZ = z;
        this.zzaXa = z2;
        this.zzaXb = str7;
        this.zzaXc = i2;
        this.zzaXd = i3;
        this.zzaXe = i4;
        this.zzaXf = z3;
        this.zzaXg = z4;
        this.zzOD = z5;
        this.zzaXk = z6;
        this.zzaXl = z7;
        this.zzaXm = str11;
        this.zzaXn = z8;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzalR = game.getApplicationId();
        this.zzaWT = game.getPrimaryCategory();
        this.zzaWU = game.getSecondaryCategory();
        this.zzacd = game.getDescription();
        this.zzaWV = game.getDeveloperName();
        this.zzaiX = game.getDisplayName();
        this.zzaWW = game.getIconImageUri();
        this.zzaXh = game.getIconImageUrl();
        this.zzaWX = game.getHiResImageUri();
        this.zzaXi = game.getHiResImageUrl();
        this.zzaWY = game.getFeaturedImageUri();
        this.zzaXj = game.getFeaturedImageUrl();
        this.zzaWZ = game.zzCV();
        this.zzaXa = game.zzCX();
        this.zzaXb = game.zzCY();
        this.zzaXc = 1;
        this.zzaXd = game.getAchievementTotalCount();
        this.zzaXe = game.getLeaderboardCount();
        this.zzaXf = game.isRealTimeMultiplayerEnabled();
        this.zzaXg = game.isTurnBasedMultiplayerEnabled();
        this.zzOD = game.isMuted();
        this.zzaXk = game.zzCW();
        this.zzaXl = game.areSnapshotsEnabled();
        this.zzaXm = game.getThemeColor();
        this.zzaXn = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzaa.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzCV()), Boolean.valueOf(game.zzCX()), game.zzCY(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzCW()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzaa.equal(game2.getApplicationId(), game.getApplicationId()) && zzaa.equal(game2.getDisplayName(), game.getDisplayName()) && zzaa.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzaa.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzaa.equal(game2.getDescription(), game.getDescription()) && zzaa.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzaa.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzaa.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzaa.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzaa.equal(Boolean.valueOf(game2.zzCV()), Boolean.valueOf(game.zzCV())) && zzaa.equal(Boolean.valueOf(game2.zzCX()), Boolean.valueOf(game.zzCX())) && zzaa.equal(game2.zzCY(), game.zzCY()) && zzaa.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzaa.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzaa.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzaa.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzaa.equal(Boolean.valueOf(game2.zzCW()), Boolean.valueOf(game.zzCW()));
            if (zzaa.equal(valueOf, Boolean.valueOf(z)) && zzaa.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzaa.equal(game2.getThemeColor(), game.getThemeColor()) && zzaa.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzaa.zzv(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzCV())).zzg("InstanceInstalled", Boolean.valueOf(game.zzCX())).zzg("InstancePackageName", game.zzCY()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzaXl;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzaXd;
    }

    public String getApplicationId() {
        return this.zzalR;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public String getDeveloperName() {
        return this.zzaWV;
    }

    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzaWV, charArrayBuffer);
    }

    public String getDisplayName() {
        return this.zzaiX;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzaiX, charArrayBuffer);
    }

    public Uri getFeaturedImageUri() {
        return this.zzaWY;
    }

    public String getFeaturedImageUrl() {
        return this.zzaXj;
    }

    public Uri getHiResImageUri() {
        return this.zzaWX;
    }

    public String getHiResImageUrl() {
        return this.zzaXi;
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getIconImageUrl() {
        return this.zzaXh;
    }

    public int getLeaderboardCount() {
        return this.zzaXe;
    }

    public String getPrimaryCategory() {
        return this.zzaWT;
    }

    public String getSecondaryCategory() {
        return this.zzaWU;
    }

    public String getThemeColor() {
        return this.zzaXm;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasGamepadSupport() {
        return this.zzaXn;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzOD;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzaXf;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzaXg;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameEntityCreator.zza(this, parcel, i);
    }

    public boolean zzCV() {
        return this.zzaWZ;
    }

    public boolean zzCW() {
        return this.zzaXk;
    }

    public boolean zzCX() {
        return this.zzaXa;
    }

    public String zzCY() {
        return this.zzaXb;
    }

    public int zzCZ() {
        return this.zzaXc;
    }
}
